package chapter1;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 16:05
 **/
public class C_07_FindCloestPalindrome {
    public static void main(String[] args) {
        for (int i = 1 ; i < 10000; i *= 2)
            System.out.println(nearestPalindromic("" + i));
    }
    private static String nearestPalindromic(String string) {
        Long num = Long.parseLong(string);
        Long raw = getRawPalindrome(string);
        Long big = raw > num ? raw : getBigPalindrome(raw);
        Long small = raw < num ? raw : getSmallPalindrome(raw);
        return String.valueOf(big - num >= num - small ? small : big);
    }

    private static Long getBigPalindrome(Long raw) {
        char[] chars = String.valueOf(raw).toCharArray();
        char[] res = new char[chars.length + 1];
        res[0] = '0';
        for (int i = 1; i <= chars.length; i++)
            res[i] = chars[i-1];
        int size = chars.length;
        for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
            if (++res[j] > '9')
                res[j] = '0';
            else
                break;
        }
        int offset = res[0] == '1' ? 1 : 0;
        size = res.length;
        for (int i = size - 1; i >= (size + offset) / 2; i--)
            res[i] = res[size - i - offset];
        return Long.valueOf(String.valueOf(res));
    }

    private static Long getSmallPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length];
        int size = res.length;
        for (int i = 0; i < size; i++) {
            res[i] = chs[i];
        }
        for (int j = (size - 1) / 2; j >= 0; j--) {
            if (--res[j] < '0') {
                res[j] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = '9';
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        for (int k = 0; k < size / 2; k++) {
            res[size - 1 - k] = res[k];
        }
        return Long.valueOf(String.valueOf(res));
    }

    private static Long getRawPalindrome(String string) {
        char[] chars = string.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++)
            chars[len-1-i] = chars[i];
        return Long.valueOf(String.valueOf(chars));
    }
}
