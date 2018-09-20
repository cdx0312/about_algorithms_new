import leetcode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 21:42
 **/
public class FindNearestNum {
    private static List<Integer> findNearestNums(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return null;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == k)
                break;
            else if (arr[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        int minus = Math.abs(arr[mid] - k);
        minus = Math.min(Math.abs(arr[mid-1] - k), minus);
        minus = Math.min(Math.abs(arr[mid+1] - k), minus);

        List<Integer> res = new ArrayList<>();
        for (int i : arr) {
            if (Math.abs(k - i) == minus)
                res.add(i);
            else if (!res.isEmpty())
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,4,4,4,6,6,6,9,17,33};
        System.out.println(findNearestNums(arr, 3));
    }
}
