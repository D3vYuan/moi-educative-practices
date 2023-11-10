package com.solution.TwoPointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ContainerMostWaterTest {

    ContainerMostWater container;

    @BeforeEach
    void init() {
        container = new ContainerMostWater();
    }

    @Test
    @DisplayName("Container Most Water Test #1 - [1,8,6,2,5,4,8,3,7]")
    void test_case_1() {
        int[] input = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int actualResult = container.containerWithMostWater(input);
        int expectedResult = 49;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Container Most Water Test #2 - [1,1]")
    void test_case_2() {
        int[] input = new int[] { 1, 1 };
        int actualResult = container.containerWithMostWater(input);
        int expectedResult = 1;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Container Most Water Test #3 - [2, 8, 6, 3, 5, 4, 7]")
    void test_case_3() {
        int[] input = new int[] { 2, 8, 6, 3, 5, 4, 7 };
        int actualResult = container.containerWithMostWater(input);
        int expectedResult = 35;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Container Most Water Test #4 - [1, 5]")
    void test_case_4() {
        int[] input = new int[] { 1, 5 };
        int actualResult = container.containerWithMostWater(input);
        int expectedResult = 1;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Container Most Water Test #5 - [7, 7, 2]")
    void test_case_5() {
        int[] input = new int[] { 7, 7, 2 };
        int actualResult = container.containerWithMostWater(input);
        int expectedResult = 7;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
