package chapter3;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 22:02
 **/
public class Code_04_JumpGame {
    private static int jump(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));
    }
}