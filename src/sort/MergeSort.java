package sort;

import java.util.Arrays;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 21:13
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {53, 23, 45, 86, 12, 33, 10, 90, 36, 70, 43, 88, 60, 29};
        System.out.println("排序之前： " + Arrays.toString(arr));
//        mergeSort(arr, 0, arr.length - 1);
        MergeSort2(arr);
        System.out.println("排序之后： " + Arrays.toString(arr));
    }

    // 递归
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j])
                tmp[k++] = arr[j++];
            else
                tmp[k++] = arr[i++];
        }
        while (i <= mid)
            tmp[k++] = arr[i++];
        while (j <= right)
            tmp[k++] = arr[j++];
        for (i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }

    // 非递归实现
    private static void MergeSort2(int[] arr) {
        int len = 1;
        while (arr.length > len) {
            for (int i = 0; i < arr.length - len - 1; i = i + 2 * len) {
                int left = i;
                int mid = i + len - 1;
                int right = i + 2 * len - 1;
                if (right > arr.length - 1)
                    right = arr.length - 1;
                merge(arr, left, mid, right);
            }
            len = len * 2;
        }
    }
}
