package chapter3;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 22:12
 **/
public class Code_06_FibonacciProblem {
    private static int fib1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fib1(n-1) + fib1(n-2);
    }

    private static int fib2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 0;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
