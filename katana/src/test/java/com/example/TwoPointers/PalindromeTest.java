package com.example.TwoPointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PalindromeTest {
    
    Palindrome palindrome;

    @BeforeEach
    void init(){
        palindrome = new Palindrome();
    }

    @Test
    @DisplayName("Palindrome Test #1 - kayak")
    void test_case_1(){
        String input = "kayak";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #2 - hello")
    void test_case_2(){
        String input = "hello";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = false;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #3 - RACEACAR")
    void test_case_3(){
        String input = "RACEACAR";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = false;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #4 - A")
    void test_case_4(){
        String input = "A";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #5 - ABCDABCD")
    void test_case_5(){
        String input = "ABCDABCD";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = false;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #6 - ABCDEFGFEDCBA")
    void test_case_6(){
        String input = "ABCDEFGFEDCBA";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #7 - ABC")
    void test_case_7(){
        String input = "ABC";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = false;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #8 - ABCBA")
    void test_case_8(){
        String input = "ABCBA";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Palindrome Test #9 - ABBA")
    void test_case_9(){
        String input = "ABBA";
        boolean actualResult = palindrome.isPalindrome(input);
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
