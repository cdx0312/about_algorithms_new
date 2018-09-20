import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-13 10:41
 **/
public class FindNearestInMatrix {
    private static List<Integer> find(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return null;
        int minMinus = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= target)
                break;
            for (int j = 0; j < arr.length; j++) {
                minMinus = Math.min(minMinus, Math.abs(arr[i][j] - target));
                if (arr[i][j] >= target)
                    break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= target)
                break;
            for (int j = 0; j < arr.length; j++) {
                if (minMinus == Math.abs(arr[i][j] - target))
                    list.add(arr[i][j]);
                if (arr[i][j] >= target)
                    break;
            }
        }
        return list;
    }
}
