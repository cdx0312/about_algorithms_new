package nowcoder.chapter6;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 16:01
 **/
public class Code_01_SubArrayMaxSum {
    private static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : arr) {
            cur += num;
            max = Math.max(max, cur);
            if (cur < 0)
                cur = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(maxSum(arr1));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(maxSum(arr2));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(maxSum(arr3));

    }
}
