import java.util.*;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-13 13:03
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");

        if (strings.length == 0 || strings.length == 1) {
            return;
        } else if (strings.length == 2) {
            System.out.println(strings[1]);
            return;
        } else if (strings.length == 3) {
            int a1 = getEditDistance(strings[1], strings[0]);
            int a2 = getEditDistance(strings[2], strings[0]);
            if (a1 <= a2)
                System.out.println(strings[1] + " " + strings[2]);
            else
                System.out.println(strings[2] + " " + strings[1]);
            return;
        }
        String dstStr = strings[0];

        int[] index = {1,2,3};
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 1; i < strings.length - 1; i++) {
            int tmp = getEditDistance(strings[i], dstStr);
            if (tmp < min[0]) {
                min[0] = tmp;
                index[0] = i;
            } else if (tmp < min[1]) {
                min[1] = tmp;
                index[1] = i;
            } else if (tmp < min[2]) {
                min[2] = tmp;
                index[2] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(strings[index[i]]).append(" ");
        }
        sb.append(strings[index[2]]);
        System.out.println(sb.toString());
    }

    private static int getEditDistance(String srcStr, String dstStr){
        int m = srcStr.length();
        int n = dstStr.length();
        // 初始化
        int d[] = new int[(m + 1) * (n + 1)];
        for(int i = 0;i <= m;i++)
            d[i * (n + 1)] = i * 3;
        for(int i = 0;i <= n;i++)
            d[i] = i * 3;
        // 动态规划
        for(int i = 1; i <= m;i++){
            for(int j = 1; j <= n;j++){
                int modifyDis = d[(i - 1) * (n + 1) + (j - 1)]
                        + (srcStr.charAt(i - 1) == dstStr.charAt(j - 1) ? 0 : 1);
                int addDis = d[(i - 1) * (n + 1) + j] + 1;
                int deleteDis = d[i * (n + 1) + (j - 1)] + 1;
                d[i * (n + 1) + j] = Math.min(Math.min(modifyDis, addDis * 3), deleteDis*3);
            }
        }
        return d[m * (n + 1) + n];
    }
}
