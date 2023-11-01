package com.solution.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.practice.SlidingWindow.RepeatedDNASequences;

import static org.assertj.core.api.Assertions.*;

public class RepeatedDNASequencesTest {
    RepeatedDNASequences sequences;

    @BeforeEach
    void init() {
        sequences = new RepeatedDNASequences();
    }

    @Test
    @DisplayName("RepeatedDNASequences Test #1 - AAAAACCCCCAAAAACCCCCC [8]")
    void test_case_1() {
        String input = "AAAAACCCCCAAAAACCCCCC";
        int length = 8;
        Set<String> expectedAnswer = new HashSet<>();
        expectedAnswer.add("AAAAACCC");
        expectedAnswer.add("AAACCCCC");
        expectedAnswer.add("AAAACCCC");
        verifyResult(input, length, expectedAnswer);
    }

    @Test
    @DisplayName("RepeatedDNASequences Test #1 - TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT [10]")
    void test_case_2() {
        String input = "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT";
        int length = 10;
        Set<String> expectedAnswer = new HashSet<>();
        
        expectedAnswer.add("CCCCCCCTTT");
        expectedAnswer.add("CCCCCCTTTT");
        expectedAnswer.add("CCCCCTTTTT");
        expectedAnswer.add("CCCCTTTTTT");
        expectedAnswer.add("TCCCCCCCTT");
        expectedAnswer.add("TTCCCCCCCT");
        expectedAnswer.add("TTTCCCCCCC");
        expectedAnswer.add("TTTTCCCCCC");
        expectedAnswer.add("TTTTTCCCCC");
        
        verifyResult(input, length, expectedAnswer);
    }

    

    public void verifyResult(String input, int length, Set<String> expectAnswer) {
        Set<String> actualAnswer = sequences.findRepeatedSequences(input, length);
        actualAnswer.forEach(System.out::println);
        assertThat(actualAnswer.size()).isEqualTo(expectAnswer.size());
        assertThat(actualAnswer).containsAll(expectAnswer);
    }
}
