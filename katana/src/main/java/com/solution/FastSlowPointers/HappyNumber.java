package com.solution.FastSlowPointers;

public class HappyNumber {
  /**
   * Write an algorithm to determine if a number n is a happy number.
   * We use the following process to check if a given number is a happy number:
   * Starting with the given number n, replace the number with the sum of the
   * squares of its digits.
   * Repeat the process until:
   * The number equals 1, which will depict that the given number n is a happy
   * number.
   * It enters a cycle, which will depict that the given number n is not a happy
   * number.
   * Return TRUE if n is a happy number, and FALSE if not.
   * 
   * Strategy
   * [1] Initialise a variable slow with the input number and fast with the
   * squared sum of the input number's digits.
   * [2] If is not 1 and also not equal to slow, increment slow by one iteration
   * and fast by two iterations. Essentially, set slow to Sum of Digits(slow) and
   * fast to Sum of Digits(Sum of Digits (fast)).
   * [3] If fast" converges to 1, return TRUE, otherwise return FALSE.
   */

  public static int sumOfSquaredDigits(int number) {
    int totalSum = 0;
    while (number != 0) {
      int digit = number % 10;
      number = number / 10;
      totalSum += (Math.pow(digit, 2));
    }
    return totalSum;
  }

  public static boolean isHappyNumber(int n) {
    int slowPointer = n;
    int fastPointer = sumOfSquaredDigits(n);

    while (fastPointer != 1 && slowPointer != fastPointer) {
      System.out.println(String.format("slowPointer: (%d)| fastPointer: (%d)", slowPointer, fastPointer));
      slowPointer = sumOfSquaredDigits(slowPointer);
      fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
      System.out.println(String.format("slowPointer: (%d)| fastPointer: (%d)", slowPointer, fastPointer));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
    return fastPointer == 1;
  }

  public static void main(String args[]) {
    int a[] = { 1, 5, 19, 25, 7 };
    for (int i = 0; i < a.length; i++) {
      System.out.println((i + 1) + ".\tInput Number: " + a[i]);
      String output = isHappyNumber(a[i]) ? "True" : "False";

      System.out.println("\n\tIs it a happy number? " + output);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
