package com.solution.DynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoinChangeTest {
    CoinChange solution;

    @BeforeEach
    void init() {
        solution = new CoinChange();
    }

    @ParameterizedTest
    @CsvSource(value = { "1,2,5;11>3", "2;4>2", "5;3>-1", "1,2,5;0>0",
            "2,3,4,6,8;23>4" }, delimiter = '>')
    void parameterized_test(String inputs, int expected) {
        String[] inputParts = inputs.split(";");
        int[] coins = Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        int total = Integer.parseInt(inputParts[1]);
        
        
        int actual = solution.coinChange(coins, total);
        assertThat(actual).isEqualTo(expected);
    }
}
