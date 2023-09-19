package com.example.LinkedListReversal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
    ReverseLinkedList reverseLinkedList;

    @BeforeEach
    void init() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    @DisplayName("ReverseLinkedList Test #1 - 2147483646")
    void test_case_1() {
        int input = 2147483646;
        boolean expectedAnswer = false;
        verifyResult(input, expectedAnswer);
    }

    public void verifyResult(int input, boolean expectAnswer) {
        boolean actualAnswer = reverseLinkedList.isHappyNumber(input);
        assertThat(actualAnswer).isEqualTo(expectAnswer);
    }
}
