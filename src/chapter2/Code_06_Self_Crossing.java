package chapter2;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 21:17
 **/
public class Code_06_Self_Crossing {
    private static boolean isSelfCrossing(int[] arr) {
        if (arr == null || arr.length < 4)
            return false;
        if (arr[2] <= arr[0] && arr[3] >= arr[1] || arr.length > 4 && arr[1] <= arr[3] && arr[4] >= arr[2] || arr.length > 4 && arr[3] == arr[1] && arr[4] == arr[2])
            return true;
        for (int i = 5; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i - 3] && ((arr[i] >= arr[i - 2]) || (arr[i - 2] >= arr[i - 4] && arr[i - 5] + arr[i - 1] >= arr[i - 3] && arr[i - 4] + arr[i] >= arr[i - 2]))) {
                return true;
            }
        }
        return false;
    }
}
