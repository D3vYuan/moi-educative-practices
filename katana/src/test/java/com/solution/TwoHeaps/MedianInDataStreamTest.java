package com.solution.TwoHeaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MedianInDataStreamTest {
    MedianInDataStream solution;

    @BeforeEach
    void init() {
        solution = new MedianInDataStream();
    }

    @ParameterizedTest
    @CsvSource(value = { "baabaad>aabaa", "aabbccddccbbae>abbccddccbba",
            "madam>madam", "morning>nin",
            "book>oo" }, delimiter = '>')
    void parameterized_test(String input, String expected) {
        // String[] inputParts = inputs.split(";");
        // int[] coins =
        // Arrays.stream(inputParts[0].split(",")).mapToInt(Integer::valueOf).toArray();
        // int total = Integer.parseInt(inputParts[1]);

        // int actual = solution.combinationSum(coins, total);
        // assertThat(actual).isEqualTo(expected);
    }
}
