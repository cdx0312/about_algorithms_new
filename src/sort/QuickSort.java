package sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/3/28
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {53, 23, 45, 86, 12, 33, 10, 90, 36, 70, 43, 88, 60, 29};
        System.out.println("排序之前： " + Arrays.toString(arr));
//        quickSort(arr, 0, arr.length - 1);
        quickSortWithNoCur(arr, 0, arr.length - 1);
        System.out.println("排序之后： " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, 0, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    private static void quickSortWithNoCur(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        if (low < high) {
            stack.push(high);
            stack.push(low);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(arr, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }
}
