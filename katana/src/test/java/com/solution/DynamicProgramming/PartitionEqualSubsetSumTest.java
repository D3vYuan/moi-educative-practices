package com.solution.DynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PartitionEqualSubsetSumTest {
    PartitionEqualSubsetSumTest solution;

    @BeforeEach
    void init() {
        solution = new PartitionEqualSubsetSumTest();
    }

    @ParameterizedTest
    @CsvSource(value = { "3,1,1,2,2,1>true", "1,3,7,3>true",
            "1,2,3>true", "1,2,5>false",
            "13,4,8>true" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
