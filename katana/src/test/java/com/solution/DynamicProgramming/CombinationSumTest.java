package com.solution.DynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CombinationSumTest {
    CombinationSum solution;

    @BeforeEach
    void init() {
        solution = new CombinationSum();
    }

    @ParameterizedTest
    @CsvSource(value = { "2,4,7,9,11;8>2,2,2,2;2,2,4;4,4", "2,3,9;12>2,2,2,2,2,2;2,2,2,3,3;3,3,3,3;3,9",
            "3,4,8,11;10>3,3,4", "3;3>3",
            "8,10;>" }, delimiter = '>')
    void parameterized_test(String inputs, int expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
