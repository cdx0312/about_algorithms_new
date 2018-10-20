package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-16 10:13
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[high] + nums[low] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);
                        while (low < high && nums[low] == nums[low+1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum)
                        low++;
                    else
                        high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,0,1,2};
        System.out.println(threeSum(arr));
    }
}