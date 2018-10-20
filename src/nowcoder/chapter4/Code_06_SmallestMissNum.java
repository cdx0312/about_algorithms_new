package nowcoder.chapter4;

import java.util.Arrays;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 13:24
 **/
public class Code_06_SmallestMissNum {
    private static int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1)
                l++;
            else if (arr[l] <= l || arr[l] > r || arr[arr[l]-1] == arr[l])
                arr[l] = arr[--r];
            else
                swap(arr, l, arr[l]-1);
            System.out.println(Arrays.toString(arr));
        }
        return l + 1;
    }

    private static void swap(int[] arr, int l, int i) {
        int tmp = arr[l];
        arr[l] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
            int[] arr = { -1, 0, 2, 1, 3, 5 };
            System.out.println(missNum(arr));
    }
}
