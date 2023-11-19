package com.solution.MergeIntervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.solution.DynamicProgramming.LongestPalindromicSubstring;

public class TaskSchedulerTest {
    TaskScheduler solution;

    @BeforeEach
    void init() {
        solution = new TaskScheduler();
    }

    @ParameterizedTest
    @CsvSource(value = { "[\"A\", \"A\", \"B\", \"B\"];2>5", "[\"A\", \"A\", \"A\", \"B\", \"B\", \"C\", \"C\"];1>7",
            "[\"S\", \"I\", \"V\", \"U\", \"W\", \"D\", \"U\", \"X\"];0>8",
            "[\"A\", \"K\", \"X\", \"M\", \"W\", \"D\", \"X\", \"B\", \"D\", \"C\", \"O\", \"Z\", \"D\", \"E\", \"Q\"];3>15",
            "[\"A\", \"B\", \"C\", \"O\", \"Q\", \"C\", \"Z\", \"O\", \"X\", \"C\", \"W\", \"Q\", \"Z\", \"B\", \"M\", \"N\", \"R\", \"L\", \"C\", \"J\"];10>34" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
