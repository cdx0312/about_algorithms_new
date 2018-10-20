import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by cdx0312
 * 2018/3/25
 */
public class AllCombine1 {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        combinetion2(str.toCharArray());
        System.out.println(list.toString());
    }

    private static void combinetion(char[] chars) {
        if (chars == null || chars.length == 0)
            return;
        int len = chars.length;
        //n=2^len
        int n = 1 << len;
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0)
                    sb.append(chars[j]);
            }
            list.add(sb.toString());
        }
    }

    private static void combinetion2(char[] chars) {
        if (chars == null || chars.length == 0)
            return;
        int len = chars.length;
        int n = 1 << len;
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if ((i & 1 << j) != 0)
                    sb.append(chars[j]);
            }
            list.add(sb.toString());
        }
    }
}