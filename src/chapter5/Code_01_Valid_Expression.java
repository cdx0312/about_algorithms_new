package chapter5;

import java.util.Stack;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 13:29
 **/
public class Code_01_Valid_Expression {
    private static boolean isValid(String expression) {
        char[] chars = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.add(ch);
            if (ch == '}' || ch == ']' || ch == ')') {
                char match;
                if (ch == '}')
                    match = '{';
                else if (ch == ']')
                    match = '[';
                else
                    match = '(';
                if (stack.isEmpty() || !stack.pop().equals(match))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{1+(2+3)+[(1+3)+(4*5)]}";
        System.out.println(isValid(test));
    }
}
