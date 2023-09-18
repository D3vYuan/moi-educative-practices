package com.example.FastSlowPointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HappyNumberTest {
    HappyNumber happyNumber;

    @BeforeEach
    void init() {
        happyNumber = new HappyNumber();
    }

    @Test
    @DisplayName("HappyNumber Test #1 - 2147483646")
    void test_case_1() {
        int input = 2147483646;
        boolean expectedAnswer = true;
        verifyResult(input, expectedAnswer);
    }

    @Test
    @DisplayName("HappyNumber Test #2 - 1")
    void test_case_2() {
        int input = 1;
        boolean expectedAnswer = true;
        verifyResult(input, expectedAnswer);
    }

    @Test
    @DisplayName("HappyNumber Test #3 - 19")
    void test_case_3() {
        int input = 19;
        boolean expectedAnswer = true;
        verifyResult(input, expectedAnswer);
    }

    @Test
    @DisplayName("HappyNumber Test #4 - 8")
    void test_case_4() {
        int input = 8;
        boolean expectedAnswer = false;
        verifyResult(input, expectedAnswer);
    }

    @Test
    @DisplayName("HappyNumber Test #5 - 7")
    void test_case_5() {
        int input = 7;
        boolean expectedAnswer = true;
        verifyResult(input, expectedAnswer);
    }

    public void verifyResult(int input, boolean expectedResult) {
        boolean actualAnswer = happyNumber.isHappyNumber(input);
        boolean expectAnswer = true;
        assertThat(actualAnswer).isEqualTo(expectAnswer);
    }
}
