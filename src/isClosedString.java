import java.util.Stack;

/**
 * @program: about_algorithms
 * @description: ${description}
 * @author: cdx
 * @create: 2018-08-26 20:06
 **/
public class isClosedString {
    public boolean isClosed(String string) {
        if (string == null)
            return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : string.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else if (ch == ')' && !stack.isEmpty()) {
                Character ch1 = stack.pop();
                if (ch1 != '(')
                    return false;
            }else if (ch == ']' && !stack.isEmpty()) {
                Character ch1 = stack.pop();
                if (ch1 != '[')
                    return false;
            }else if (ch == '}' && !stack.isEmpty()) {
                Character ch1 = stack.pop();
                if (ch1 != '{')
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]()}]";
        boolean res = new isClosedString().isClosed(s);
        System.out.println(res);
    }
}
