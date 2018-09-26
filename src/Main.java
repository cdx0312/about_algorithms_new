import java.util.*;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-15 16:46
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int A = sc.nextInt();
        int R= sc.nextInt();
        System.out.println(getRes(M, A, R));
    }

    private static double getRes(int M, int A, int R) {
        if (A + R <= M)
            return 1;
        double[] res = new double[M+1];
        res[0] = 0;
        for (int i = 1; i < R + 1; i++) {
            if (i <= M)
                res[i] += 1 * 1.0 / R;
        }
        for (int a = 1; a < A;a++) {
            for (int i = a; i < M+1; i++) {
                double tmp = 0.0;
                if (i < R) {
                    for (int j = 0; j < i; j++)
                        tmp += res[j];
                    res[i] += tmp / R;
                } else {
                    for (int j = 0; j < R; j++)
                        tmp += res[i-j];
                    res[i] += tmp / R;
                }
            }
        }
        double sum = 0;
        for (double d : res) {
            sum += d;
        }
        return sum;
    }
}
