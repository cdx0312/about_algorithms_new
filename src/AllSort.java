import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/3/25
 */
public class AllSort {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        Permutation(str.toCharArray(), str.length(), 0);
        PermutationWithDictionary(str.toCharArray(), str.length());
        System.out.println(list.toString());
    }

    private static void Permutation(char[] chars, int strLen, int curIndex) {
        //如果到最后一个数，将排好的加入到list中
        if (curIndex == strLen - 1) {
            list.add(new String(chars));
        } else {
            for (int i = curIndex; i <= strLen - 1; i++) {
                //去重，避免相同数字的交换造成最终结果存在重复
                if (i == curIndex || chars[i] != chars[curIndex]) {
                    //依次交换开头字母与后面的进行递归
                    Swap(chars, i, curIndex);
                    Permutation(chars, strLen, curIndex + 1);
                    Swap(chars, i, curIndex);
                }
            }
        }
    }

    private static void Swap(char[] chars, int i, int curIndex) {
        char tmp = chars[i];
        chars[i] = chars[curIndex];
        chars[curIndex] = tmp;
    }

    private static void PermutationWithDictionary(char[] chars, int strLen) {
        //对字符数组进行排序
        Arrays.sort(chars);

        while (true) {
            int j;
            int index = 0;
            //找到从右向左第一个不是非递增元素
            for (j = strLen - 2; j >= 0; j--) {
                if (chars[j] < chars[j + 1]) {
                    index = j;
                    break;
                } else if (j == 0) {
                    return;
                }
            }
            //与从右向左第一个大于这个元素的元素交换
            for (j = strLen - 1; j >= 0; j--) {
                if (chars[j] > chars[index]) {
                    break;
                }
            }
            //交换这两个值
            Swap(chars, index, j);
            //对非递增元素位置后面的数组进行逆序排序
            Reverse(chars, index + 1);
            list.add(new String(chars));
        }
    }

    private static void Reverse(char[] chars, int index) {
        int k = index, j = chars.length - 1;
        while (k < j) {
            Swap(chars, k, j);
            k++;
            j--;
        }
    }
}
