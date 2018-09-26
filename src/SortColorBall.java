import java.util.Scanner;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-21 09:34
 **/
public class SortColorBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int red = sc.nextInt();
        int yellow = sc.nextInt();
        int green = sc.nextInt();
        System.out.println(getResult(red, yellow, green));
    }

    private static int getResult(int red, int yellow, int green) {
        int[][][] arr = new int[red + 1][yellow + 1][green + 1];
        // 初始化
        for (int i = 0; i <= red; i++)
            for (int j = 0; j <= yellow; j++)
                for (int k = 0; k <= green; k++)
                    arr[i][j][k] = 0;

        for (int i = 1; i <= red; i++) {
            for (int j = 1; j <= yellow; j++) {
                for (int k = 1; k <= green; k++) {
                    if (i == 1 && j == 1 && k == 1) {
                        arr[i][j][k] = 6;
                        continue;
                    }
                    if (i == j && j == k) {
                        arr[i][j][k] = arr[i - 1][j][k] * (k + j + 2 - i);
                        if (j > 1)
                            arr[i][j][k] += arr[i - 1][j - 1][k] * (j - 1) * 2;
                        arr[i][j][k] /= i;
                        continue;
                    }
                    if (j == k) {
                        arr[i][j][k] = arr[i][j - 1][k] * (i + k + 2 - j);
                        if (i > 1) {
                            arr[i][j][k] += arr[i - 1][j - 1][k] * (i - 1);
                        }
                        if (k > 1) {
                            arr[i][j][k] += arr[i][j - 1][k - 1] * (k - 1);
                        }
                        arr[i][j][k] = arr[i][j][k] / j;
                        continue;
                    }
                    if (k > (j + i + 1))
                        break;

                    arr[i][j][k] = arr[i][j][k - 1] * (i + j + 2 - k);
                    if (i > 1) {
                        arr[i][j][k] += arr[i - 1][j][k - 1] * (i - 1);
                    }

                    if (j > 1 && j > i) {
                        arr[i][j][k] += arr[i][j - 1][k - 1] * (j - 1);
                    } else if (j > 1 && j == i) {
                        arr[i][j][k] += arr[i - 1][j][k - 1] * (i - 1);
                    }
                    arr[i][j][k] = arr[i][j][k] / k;
                }
            }
        }
        return arr[red][yellow][green];
    }
}
