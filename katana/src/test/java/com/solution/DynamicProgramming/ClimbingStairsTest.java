package com.solution.DynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClimbingStairsTest {
    ClimbingStairs solution;

    @BeforeEach
    void init() {
        solution = new ClimbingStairs();
    }

    @ParameterizedTest
    @CsvSource(value = { "5>8", "10>89", "30>1346269", "42>433494437", "9>55" }, delimiter = '>')
    void parameterized_test(int input, int expected) {
        int actual = solution.climbStairs(input);
        assertThat(actual).isEqualTo(expected);
    }
}
