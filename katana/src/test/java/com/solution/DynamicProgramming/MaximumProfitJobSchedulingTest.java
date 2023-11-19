package com.solution.DynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MaximumProfitJobSchedulingTest {
    MaximumProfitJobScheduling solution;

    @BeforeEach
    void init() {
        solution = new MaximumProfitJobScheduling();
    }

    @ParameterizedTest
    @CsvSource(value = { "[1, 2, 3] , [3, 4, 5] , [50, 10, 40]>90",
            "[2, 4, 6, 8, 10] , [5, 7, 9, 11, 13] , [40, 20, 50, 70, 30]>120",
            "[15, 20, 25, 30, 35] , [18, 23, 28, 33, 38] , [80, 60, 90, 110, 70]>410",
            "[1, 4] , [5, 7] , [1000, 3]>1000",
            "[2, 5, 1, 8, 3, 7, 6, 10, 4, 9] , [7, 10, 4, 11, 6, 9, 8, 12, 5, 13] , [80, 50, 60, 90, 30, 70, 40, 100, 20, 110]>260" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
