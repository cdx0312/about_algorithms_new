package nowcoder.chapter1;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-21 14:30
 **/
public class C_01_PalindromeNumber {
    public static boolean isPalindrome(int n) {
        if (n < 0)
            return false;
        int help = 1;

        while (n / help >= 10)
            help *= 10;

        while (n != 0) {
            if (n / help != n % 10)
                return false;
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }
}
