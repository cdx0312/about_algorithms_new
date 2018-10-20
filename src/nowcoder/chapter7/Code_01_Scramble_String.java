package nowcoder.chapter7;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 18:41
 **/
public class Code_01_Scramble_String {
    private static boolean isScramble1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int N = s1.length();
        return func2(s1.toCharArray(), s2.toCharArray(), 0, 0, N);
    }

    private static boolean func2(char[] chars, char[] chars1, int l1, int l2, int size) {
        if (size == 1)
            return chars[l1] == chars[l2];
        for (int part = 1; part < size; part++) {
            if ((func2(chars, chars1, l1, l2, size - part) &&
                    func2(chars, chars1, l1+part, l2 + part, size - part))
                    || (func2(chars, chars1, l1, l2 + size - part, part) &&
                    func2(chars, chars1, l2 + part, l2, size - part)))
                return true;
        }
        return false;
    }
}
