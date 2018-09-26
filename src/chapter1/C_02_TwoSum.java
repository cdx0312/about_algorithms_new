package chapter1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-21 14:30
 **/
public class C_02_TwoSum {
    // HashMap方法
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // 双指针法
    private static int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[nums.length];
        for (int i = 0; i < indices.length; i++)
            indices[i] = i;
        sort(nums, indices);
        int low = 0;
        int high = nums.length - 1;
        int sum = 0;
        while (low < high) {
            sum = nums[low] + nums[high];
            if (sum > target)
                high--;
            else if (sum < target)
                low++;
            else
                return new int[]{indices[low], indices[high]};
        }
        return new int[] { -1, -1};
    }
    private static void sort(int[] nums, int[] indices) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, indices, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, indices, 0, i);
            heapify(nums, indices, i);
        }
    }

    private static void heapInsert(int[] nums, int[] indices, int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (nums[i] <= nums[p]) {
                break;
            }
            swap(nums, indices, i, p);
            i = p;
        }
    }

    private static void heapify(int[] nums, int[] indices, int size) {
        int i = 0;
        int left = 1;
        int right = 2;
        int largest;
        while (left < size) {
            largest = nums[left] > nums[i] ? left : i;
            largest = right < size && nums[right] > nums[largest] ? right : largest;
            if (largest == i) {
                break;
            }
            swap(nums, indices, largest, i);
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    private static void swap(int[] nums, int[] indices, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        tmp = indices[i];
        indices[i] = indices[j];
        indices[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(twoSum(nums, 17)));
        System.out.println(Arrays.toString(twoSum2(nums, 7)));
    }
}
