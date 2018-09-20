import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 14:30
 **/
public class AllSort {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        permutation(str.toCharArray(), str.length(), 0);
        System.out.println(list.toString());
    }

    private static void permutation(char[] chars, int strLen, int curIndex) {
        if (curIndex == strLen - 1)
            list.add(new String(chars));
        else {
            for (int i = curIndex; i < strLen - 1; i++) {
                if (i == curIndex || chars[i] != chars[curIndex]) {
                    swap(chars, i, curIndex);
                    permutation(chars, strLen, curIndex + 1);
                    swap(chars, i, curIndex);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int curIndex) {
        char tmp = chars[i];
        chars[i] = chars[curIndex];
        chars[curIndex] = tmp;
    }
}
