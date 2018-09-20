/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 21:42
 **/
public class FindAppealTimeInArray {
    private static int findAppearTimeInArray(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
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
        low = mid;
        high = mid;
        while (arr[low - 1] == k) {
            low--;
            if (low == 0)
                break;
        }
        while (high < arr.length - 1 && arr[high + 1] == k){
            high++;
            if (high == arr.length - 1)
                break;
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3,4,4,4,5,6,6,7,8,9};
        for (int i = 1; i < 10; i++)
            System.out.println(findAppearTimeInArray(arr, i));
    }
}
