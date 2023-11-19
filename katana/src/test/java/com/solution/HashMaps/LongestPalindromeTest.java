package com.solution.HashMaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.solution.DynamicProgramming.LongestPalindromicSubstring;

public class LongestPalindromeTest {
    LongestPalindrome solution;

    @BeforeEach
    void init() {
        solution = new LongestPalindrome();
    }

    @ParameterizedTest
    @CsvSource(value = { "opinion>7", "cool>3",
            "GooooooOOOOODdddD>15", "REaccaR>7",
            "AbcDeFGhAachDeFG>15" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
