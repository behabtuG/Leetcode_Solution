package leetcode.com.Medium.EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Deque<Long> stack = new ArrayDeque<>();

        for (final String token : tokens)
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    final long b = stack.pop();
                    final long a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Long.parseLong(token));
            }

        return stack.peek().intValue();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};  //Output: 22
        System.out.println(evalRPN(tokens));
    }
}
