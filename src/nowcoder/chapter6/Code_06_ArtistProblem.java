package nowcoder.chapter6;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-26 17:19
 **/
public class Code_06_ArtistProblem {
    public static int solution1(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 1)
            return 0;
        int[] sumArr = new int[arr.length];
        int[] map = new int[arr.length];
        sumArr[0] = arr[0];
        map[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
            map[i] = sumArr[i];
        }
        for (int i = 1; i < num; i++) {
            for (int j = map.length - 1; j > i-1; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = i-1; k < j; k++) {
                    int cur = Math.max(map[k], sumArr[j] - sumArr[k]);
                    min = Math.min(min, cur);
                }
                map[j] = min;
            }
        }
        return map[arr.length - 1];
    }
}