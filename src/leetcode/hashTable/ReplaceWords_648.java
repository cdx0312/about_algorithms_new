package leetcode.hashTable;

import java.util.Arrays;
import java.util.List;

/**
 * @program: about_algorithms
 * @description: ${description}
 * @author: cdx
 * @create: 2018-08-26 15:56
 **/
public class ReplaceWords_648 {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || sentence == null || sentence.equals(""))
            return sentence;
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String tmp = strings[i];
            for (String d : dict) {
                if (d.length() <= tmp.length() && tmp.subSequence(0, d.length()).equals(d)) {
                    tmp = d;
                }
            }
            strings[i] = tmp;
        }
        return String.join(" ", strings);
    }

    public static void main(String[] args) {
        String[] dict1 = new String[]{"a", "aa", "aaa", "aaaa"};
        List<String> dict = Arrays.asList(dict1);
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(new ReplaceWords_648().replaceWords(dict, sentence));
    }
}
