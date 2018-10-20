package nowcoder.chapter3;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 21:47
 **/
public class Code_03_ConvertStringToInteger {
    private static int String2Integer(String string) {
        if (string == null || string.equals(""))
            return 0;
        char[] chars = string.toCharArray();
        if (!isValid(chars))
            return 0;
        boolean flag = chars[0] == '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = flag?1:0; i < chars.length; i++) {
            cur = '0' - chars[i];
            if (res < minq || (res == minq && cur < minr))
                return 0;
            res = res * 10 + cur;
        }
        if (!flag && res == Integer.MIN_VALUE)
            return 0;
        return flag ? res : -res;
    }

    private static boolean isValid(char[] chars) {
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9'))
            return false;
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0'))
            return false;
        if (chars[0] == '0' && chars.length > 1)
            return false;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(String2Integer(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(String2Integer(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(String2Integer(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(String2Integer(test4));

        String test5 = "-123";
        System.out.println(String2Integer(test5));
    }
}
