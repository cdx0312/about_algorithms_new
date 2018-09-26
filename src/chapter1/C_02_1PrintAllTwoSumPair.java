package chapter1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-21 14:30
 **/
public class C_02_1PrintAllTwoSumPair {
    private static void printUniqueTwoSumPair(int[] arr, int target) {
        if (arr == null || arr.length < 2)
            return;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum < target)
                low++;
            else if (sum > target)
                high--;
            else {
                if (low == 0 || arr[low-1] != arr[low])
                    System.out.println(arr[low] + ", " + arr[high]);
                low++;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        printUniqueTwoSumPair(nums, 15);
    }
}
