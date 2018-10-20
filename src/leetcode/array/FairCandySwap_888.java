package leetcode.array;

import java.util.HashSet;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 17:32
 **/
public class FairCandySwap_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            sumA += i;
            set.add(i);
        }
        for (int j : B)
            sumB += j;
        int swap = (sumB - sumA) / 2;
        int[] res = new int[2];
        for (int j : B) {
            if (set.contains(j-swap)) {
                res[0] = j - swap;
                res[1] = j;
                return res;
            }
        }
        return res;
    }
}
