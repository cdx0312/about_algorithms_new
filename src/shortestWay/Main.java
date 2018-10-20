package shortestWay;

import java.util.Scanner;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-13 20:37
 * 输入一个矩阵M×N，现在从左上角到达右下角，且只能向下或者向右走。
 * 我们要求的是路径经过的所有点的数字之和的最大值。
 * **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            System.out.println(dfs(arr, 0, 0));
            System.out.println(getMaxPathSum(arr));
        }
    }

    // dfs
    private static int dfs(int[][] arr, int i, int j) {
        if (i == arr.length || j == arr[0].length)
            return 0;
        else if (i == arr.length - 1 && j == arr.length - 1)
            return arr[i][j];
        else
            return Math.max(dfs(arr, i + 1, j), dfs(arr, i, j + 1)) + arr[i][j];
    }

    // 动态规划
    private static int getMaxPathSum(int[][] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = nums[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + nums[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j-1] + nums[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + nums[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
