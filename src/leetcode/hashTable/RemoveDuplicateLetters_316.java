package leetcode.hashTable;

import java.util.*;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-12 16:12
 **/
public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return s;
        List<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (list.contains(ch))
                list.remove(new Character(ch));
            list.add(ch);
        }
        for (char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSum("-1+11+345-123+444-3-3+4"));
    }

    private static int getSum(String s) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+')
                flag = true;
            else if (ch == '-')
                flag = false;
            else {
                int temp = 0;
                while (i < s.length()) {
                    if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                        i--;
                        break;
                    }
                    temp = temp * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (flag)
                    sum += temp;
                else
                    sum -= temp;
            }
        }
        return sum;
    }
}
