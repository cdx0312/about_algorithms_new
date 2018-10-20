package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 17:42
 **/
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] record = new int[50000];
        for (int i : nums) {
            record[i]++;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int aRecord : record) {
            maxValue = Math.max(maxValue, aRecord);
        }
        List<Integer> maxIndexList = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] == maxValue)
                maxIndexList.add(i);
        }
        int res = Integer.MAX_VALUE;
        for (Integer maxIndex : maxIndexList) {
            int low = 0;
            while (nums[low] != maxIndex)
                low++;
            int high = nums.length - 1;
            while (nums[high] != maxIndex)
                high--;
            res = Math.min(res, high - low + 1);
        }

        return res;
    }
}
