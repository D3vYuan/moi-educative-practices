package com.solution.DynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordBreakTest {
    WordBreak solution;

    @BeforeEach
    void init() {
        solution = new WordBreak();
    }

    @ParameterizedTest
    @CsvSource(value = { "magiclly,[\"ag\", \"al\", \"icl\", \"mag\", \"magic\", \"ly\", \"lly\"]>false",
            "raincoats,[\"rain\", \"oats\", \"coat\", \"s\", \"rains\", \"oat\", \"coats\", \"c\"]>false",
            "highway,[\"crash\", \"cream\", \"high\", \"low\", \"away\"]>false",
            "robocat,[\"rob\", \"cat\", \"obo\", \"bo\", \"b\"]>false",
            "cocomomo,[\"c\", \"m\", \"coc\", \"o\", \"momo\"]>true" }, delimiter = '>')
    void parameterized_test(String input, int expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
