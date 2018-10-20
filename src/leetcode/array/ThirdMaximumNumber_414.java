package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 19:29
 **/
public class ThirdMaximumNumber_414 {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(new ThirdMaximumNumber_414().thirdMax(nums));
    }
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Set<Integer> record = new HashSet<>();
        for (int i : nums) {
            record.add(i);
        }
        int res;
        if (record.size() < 3) {
            int tmp = Integer.MIN_VALUE;
            for (int i : record)
                tmp = Math.max(tmp, i);
            res = tmp;
        } else {
            int max = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
            for (int i : record) {
                if (max <= i) {
                    max3 = max2;
                    max2 = max;
                    max = i;
                }
                else {
                    if (max2 <= i)
                        max2 = i;
                    else
                        max3 = Math.max(i, max3);
                }
            }
            res = max3;
        }
        return res;
    }
}
