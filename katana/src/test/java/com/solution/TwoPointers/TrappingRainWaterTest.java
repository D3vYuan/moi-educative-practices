package com.solution.TwoPointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterTest {

    TrappingRainWater application;

    @BeforeEach
    void init() {
        application = new TrappingRainWater();
    }

    @Test
    @DisplayName("Trapping Rain Water Test #1 - [1,0,3,0,1,2]")
    void test_case_1() {
        int[] input = new int[] { 1, 0, 3, 0, 1, 2 };
        int actualResult = application.rainWater(input);
        int expectedResult = 4;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Trapping Rain Water Test #2 - [4, 2, 0, 3, 1, 5]")
    void test_case_2() {
        int[] input = new int[] { 4, 2, 0, 3, 1, 5 };
        int actualResult = application.rainWater(input);
        int expectedResult = 10;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Trapping Rain Water Test #3 - [0, 3, 0, 2, 1, 0, 1, 4, 2, 1, 2, 0]")
    void test_case_3() {
        int[] input = new int[] { 0, 3, 0, 2, 1, 0, 1, 4, 2, 1, 2, 0 };
        int actualResult = application.rainWater(input);
        int expectedResult = 12;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Trapping Rain Water Test #4 - [1, 2, 2, 2, 2, 2]")
    void test_case_4() {
        int[] input = new int[] { 1, 2, 2, 2, 2, 2 };
        int actualResult = application.rainWater(input);
        int expectedResult = 0;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Trapping Rain Water Test #5 - [4]")
    void test_case_5() {
        int[] input = new int[] { 4 };
        int actualResult = application.rainWater(input);
        int expectedResult = 0;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
