import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-15 16:46
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWorkers = sc.nextInt();
        int[] arr = new int[numberOfWorkers];
        for (int i = 0; i < numberOfWorkers; i++)
            arr[i] = sc.nextInt();
        int res = 0;
        for (int i = 0; i < numberOfWorkers - 1; i++) {
            Arrays.sort(arr);
            res += arr[i] + arr[i+1];
            arr[i+1] = arr[i] + arr[i+1];
        }
        System.out.println(res);
    }
}
