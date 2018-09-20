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

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int k = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right])
                tmp[k++] = arr[left++];
            else
                tmp[k++] = arr[right++];
        }
        while (left <= mid)
            tmp[k++] = arr[left++];
        while (right <= high)
            tmp[k++] = arr[right++];
        for (int i : tmp)
            arr[low++] = i;
    }

    private static void sort(int[] arr) {
        int len = 1;
        while (arr.length > len) {
            for (int i = 0; i < arr.length -len - 1; i += 2 * len) {
                int left = i;
                int mid = i + left - 1;
                int right = i + 2 * len - 1;
                if (right > arr.length - 1)
                    right = arr.length - 1;
                merge(arr, left, mid, right);
            }
            len = len * 2;
        }
    }

    // 递归实现方案
    public static void mergeSort(int[] arrays, int L, int R) {

        //如果只有一个元素，那就不用排序了
        if (L == R) {
            return;
        } else {
            //取中间的数，进行拆分
            int M = (L + R) / 2;

            //左边的数不断进行拆分
            mergeSort(arrays, L, M);

            //右边的数不断进行拆分
            mergeSort(arrays, M + 1, R);

            //合并
            merge(arrays, L, M + 1, R);

        }
    }

//    public static void merge(int[] arrays, int L, int M, int R) {
//
//        //左边的数组的大小
//        int[] leftArray = new int[M - L];
//
//        //右边的数组大小
//        int[] rightArray = new int[R - M + 1];
//
//        //往这两个数组填充数据
//        for (int i = L; i < M; i++) {
//            leftArray[i - L] = arrays[i];
//        }
//
//        for (int i = M; i <= R; i++) {
//            rightArray[i - M] = arrays[i];
//        }
//
//        int i = 0, j = 0;
//        // arrays数组的第一个元素
//        int  k = L;
//
//        //比较这两个数组的值，哪个小，就往数组上放
//        while (i < leftArray.length && j < rightArray.length) {
//
//            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
//            if (leftArray[i] < rightArray[j]) {
//                arrays[k] = leftArray[i];
//
//                i++;
//                k++;
//            } else {
//                arrays[k] = rightArray[j];
//                j++;
//                k++;
//            }
//        }
//
//        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
//        while (i < leftArray.length) {
//            arrays[k] = leftArray[i];
//
//            i++;
//            k++;
//        }
//        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
//        while (j < rightArray.length) {
//            arrays[k] = rightArray[j];
//            k++;
//            j++;
//        }
//    }

    // 非递归实现方案
    private static void MergeSort2(int[] arr) {
        int len = 1;
        while (arr.length > len) {
            for (int i = 0; i <= arr.length - 1; i++) {
                int left = i;
            }
        }
    }

}
