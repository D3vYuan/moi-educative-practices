package com.solution.MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MergeIntervalsTest {
    MergeIntervals mergeIntervals;

    @BeforeEach
    void init() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    @DisplayName("MergeIntervals Test #1 - [[1,5],[3,7],[4,6]]")
    void test_case_1(){
        int [][] inputArray = {
            {1, 5},
            {3, 7},
            {4, 6},
        };

        int [][] expectedArray = {
            {1, 7}
        };

        List<Interval> input = buildInterval(inputArray); 
        List<Interval> expectedAnswer = buildInterval(expectedArray);
        verifyResult(input, expectedAnswer);
    }

    public void verifyResult(List<Interval> input, List<Interval> expectedAnswer) {
        List<Interval> actualAnswer = mergeIntervals.mergeIntervals(input);
        assertThat(actualAnswer.size()).isEqualTo(expectedAnswer.size());
        
        expectedAnswer.stream().forEach(e -> {
            int start = e.getStart();
            int end = e.getEnd();
            Optional<Interval> matchingAnswer = actualAnswer.stream().filter(a -> a.getStart() == start && a.getEnd() == end).findAny();
            assertThat(matchingAnswer.isPresent()).isTrue();
        });
    }

    public static List<Interval> buildInterval(int[][] intervalStartEndValues){
        List<Interval> result = new ArrayList<>();
        
        for (int[] intervalValue : intervalStartEndValues){
            int currentStart = intervalValue[0];
            int currentEnd = intervalValue[1];
            Interval currentInterval = new Interval(currentStart, currentEnd);
            result.add(currentInterval);
        }

        return result;
    }
}
