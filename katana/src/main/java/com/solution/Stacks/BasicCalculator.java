package com.solution.Stacks;

import java.util.Stack;

public class BasicCalculator {
    /**
     * Given a string containing an arithmetic expression, implement a basic
     * calculator that evaluates the expression string. The expression string can
     * contain integer numeric values and should be able to handle the “+” and “-”
     * operators, as well as “()” parentheses.
     * 
     * Strategy
     * [1] Initialize a stack to manage nested expressions and three variables for
     * the current number, sign value, and result.
     * [2] Iterate through the input string to process the equation. Determine if
     * the character is a digit, parenthesis, or operator.
     * [3] When encountering a digit, update the number variable by appending the
     * digit to it.
     * [4] For operators (+ and -), compute the left expression using the current
     * sign and update the result.
     * [5] If an opening parenthesis is found, push the current result and sign onto
     * the stack for nested expressions. For a closing parenthesis, compute the
     * expression within it and update the result.
     * [6] Once the whole expression is traversed, return the final result, which
     * represents the evaluated arithmetic expression.
     */

    public BasicCalculator() {

    }

    public int calculator(String expression) {
        int signValue = 1;
        int number = 0;
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int expressionIndex = 0; expressionIndex < expression.length(); expressionIndex++) {
            char expressionCharacter = expression.charAt(expressionIndex);
            if (Character.isDigit(expressionCharacter)) {
                System.out.println(String.format("found(): is digit for %s", expressionCharacter));
                number = number * 10 + Character.getNumericValue(expressionCharacter);
            } else if (expressionCharacter == '+' || expressionCharacter == '-') {
                System.out.println(String.format("found(): is sign for %s", expressionCharacter));
                result += number * signValue;
                signValue = expressionCharacter == '-' ? -1 : 1;
                number = 0;
            } else if (expressionCharacter == '(') {
                System.out.println(String.format("found(): is open bracket for %s", expressionCharacter));
                stack.push(result);
                stack.push(signValue);
                result = 0;
                signValue = 1;
            } else if (expressionCharacter == ')') {
                System.out.println(String.format("found(): is close bracket for %s", expressionCharacter));

                result += number * signValue;
                int stackSignValue = stack.pop();
                result *= stackSignValue;

                int stackNumberValue = stack.pop();
                result += stackNumberValue;
                number = 0;
            }
        }
        return result + number * signValue;
    }
}
