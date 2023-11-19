package com.solution.DynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UniquePaths {
    UniquePaths solution;

    @BeforeEach
    void init() {
        solution = new UniquePaths();
    }

    @ParameterizedTest
    @CsvSource(value = { "3,7>28", "3,2>3",
            "3,3>6", "7,3>28",
            "2,1>1" }, delimiter = '>')
    void parameterized_test(String input, int expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
