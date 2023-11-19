package com.solution.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    /**
     * 
     * Strategy
     * [1] Start traversing the input string. If the current parenthesis is an
     * opening parenthesis, push it onto the stack.
     * [2] If the current parenthesis is a closing parenthesis and it corresponds to
     * the opening parenthesis on the top of the stack, then pop it from the stack.
     * [3] After complete traversal, if the stack is empty, then the parentheses are
     * valid. Otherwise they are not.
     */

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        for (char ch : s.toCharArray()) {
            // If the character is an opening bracket
            if (!hashMap.containsKey(ch)) {
                // Simply push it onto the stack
                stack.push(ch);
            } else {
                // Pop the element from the stack, if it is not empty
                char poppedElement = (stack.isEmpty()) ? '*' : stack.pop();

                // If the mapping for the opening bracket in our hashmap and the popped
                // element of the stack don't match, return false
                if (hashMap.get(ch) != poppedElement) {
                    return false;
                }
            }
        }

        // If the stack is empty, we will return true; otherwise, false
        return stack.isEmpty();
    }
}
