import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/3/25
 */
public class AllCombine {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        combinetion(str.toCharArray(), str.length());
        System.out.println(list.toString());
    }

    private static void combinetion(char[] chars, int length) {
        if (chars == null || length == 0)
            return;
        List<Character> array = new ArrayList<>();
        //n中情况分别考虑
        for (int i = 1; i <= length; i++) {
            combine(chars, 0, i, array);
        }
    }

    /**
     * 从字符数组中index以后挑选number个数加入list
     * @param chars 输入的字符数组
     * @param index 开始字符下标
     * @param number
     * @param array
     */
    private static void combine(char[] chars, int index, int number, List<Character> array) {
        if (number == 0) {
            //递归终止条件，判断是为了去重
            if (!list.contains(array.toString())) {
                list.add(array.toString());
            }
            return;
        }
        if (index == chars.length) {
            return;
        }
        //取当前元素，并考察递归选取n-1个元素的情况
        array.add(chars[index]);
        combine(chars, index+1, number - 1, array);
        array.remove((Character) chars[index]);
        //不取当前元素，考察后面选取n个元素
        combine(chars, index+1, number, array);
    }
}
