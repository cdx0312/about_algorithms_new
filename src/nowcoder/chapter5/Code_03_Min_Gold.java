package nowcoder.chapter5;

import java.util.Arrays;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 13:49
 **/
public class Code_03_Min_Gold {
    public static void main(String[] args) {
        int[] knights1 = { 2, 10, 5 };
        int[] dragons1 = { 3, 8, 6 };
        System.out.println(minGold1(knights1, dragons1));

        int[] knights2 = { 2, 10, 5 };
        int[] dragons2 = { 3, 8, 6 };
        System.out.println(minGold2(knights2, dragons2));

    }

    private static int minGold1(int[] knights, int[] dragons) {
        Arrays.sort(knights);
        int res = 0;
        for (int dragon : dragons) {
            int cost = getMaxLeftMost(knights, dragon);
            if (cost == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            res += cost;
        }
        return res;
    }

    private static int getMaxLeftMost(int[] knights, int dragon) {
        int L = 0;
        int R = knights.length - 1;
        int res = -1;
        while (L <= R) {
            int mid = (L+R)/2;
            if (knights[mid] < dragon)
                L = mid + 1;
            else {
                res = mid;
                R = mid - 1;
            }

        }
        return res == -1 ? Integer.MAX_VALUE : knights[res];
    }

    private static int minGold2(int[] knights, int[] dragons) {
        int sum = 0;
        for (int knight : knights)
            sum += knight;
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[knights[0]] = knights[0];
        for (int i = 1; i < knights.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - knights[i] >= 0 && dp[j - knights[i]] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - knights[i]] + knights[i]);
                }
            }
        }
        for (int i = dp.length - 2; i >= 0; i--)
            dp[i] = Math.min(dp[i], dp[i+1]);

        int res = 0;
        for (int dragon : dragons) {
            int cost = getMaxLeftMost(dp, dragon);
            if (cost == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            res += cost;
        }
        return res;
    }

    public static void printArray(int[] dp) {
        for (int aDp : dp) {
            System.out.print((aDp == Integer.MAX_VALUE ? "X" : aDp) + " ");
        }
        System.out.println();
    }
}