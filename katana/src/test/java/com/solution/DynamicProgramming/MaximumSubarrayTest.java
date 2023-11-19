package com.solution.DynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MaximumSubarrayTest {
    MaximumSubarray solution;

    @BeforeEach
    void init() {
        solution = new MaximumSubarray();
    }

    @ParameterizedTest
    @CsvSource(value = { "[-2, 1, -3, 4, -1, 2, 1, -5, 4]>6", "[1]>1",
            "[-2, 1, -3, 4, 1, -1, 2, 1, -3, 4, -2, -5>8", "[-10, 2, 9, 4, -6, -3, 1, 2, 4, -3, 6]>16",
            "[-3, -2, -8, -7, -6, -4, -6, -3]>-2" }, delimiter = '>')
    void parameterized_test(String input, int expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
