package nowcoder.chapter6;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 16:56
 **/
public class Code_03_SubArrayMaxProduct {
    private static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            double anArr = arr[i];
            maxEnd = max * anArr;
            minEnd = min * anArr;
            max = Math.max(Math.max(maxEnd, minEnd), anArr);
            min = Math.min(Math.min(maxEnd, minEnd), anArr);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
        System.out.println(maxProduct(arr));
    }
}
