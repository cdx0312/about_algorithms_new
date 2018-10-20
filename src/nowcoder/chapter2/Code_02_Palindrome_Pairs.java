package nowcoder.chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 19:56
 **/
public class Code_02_Palindrome_Pairs {
    private static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordSet = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            wordSet.put(words[i], i);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            res.addAll(findAll(words[i],i, wordSet));
        }
        return res;
    }

    private static List<List<Integer>> findAll(String word, int index, HashMap<String, Integer> wordSet) {
        List<List<Integer>> res = new ArrayList<>();
        int[] rs = manacherrs(word);
        String reverse = reverse(word);
        Integer rest = wordSet.get("");
        if (rest != null && rest != index && word.equals(reverse)){
            addRecord(res, rest, index);
            addRecord(res, index, rest);
        }
        int mid = rs.length >> 1;
        for (int i = 1; i < mid; i++) {
            if (i - rs[i] == -1) {
                rest = wordSet.get(reverse.substring(0, mid - i));
                if (rest != null && rest != index) {
                    addRecord(res, rest, index);
                }
            }
        }
        for (int i = mid + 1; i < rs.length; i++) {
            if (i + rs[i] == rs.length) {
                rest = wordSet.get(reverse.substring((mid << 1) - i));
                if (rest != null && rest != index) {
                    addRecord(res, index, rest);
                }
            }
        }
        return res;
    }

    private static String reverse(String str) {
        char[] chs = str.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l < r) {
            chs[l] ^= chs[r];
            chs[r] ^= chs[l];
            chs[l++] ^= chs[r--];
        }
        return String.valueOf(chs);
    }

    private static void addRecord(List<List<Integer>> res, int left, int right) {
        List<Integer> newr = new ArrayList<>();
        newr.add(left);
        newr.add(right);
        res.add(newr);
    }

    private static int[] manacherrs(String word) {
        char[] mchs = manachercs(word);
        int[] rs = new int[mchs.length];
        int center = -1;
        int pr = -1;
        for (int i = 0; i != mchs.length; i++) {
            rs[i] = pr > i ? Math.min(rs[(center << 1) - i], pr - i) : 1;
            while (i + rs[i] < mchs.length && i - rs[i] > -1) {
                if (mchs[i + rs[i]] != mchs[i - rs[i]]) {
                    break;
                }
                rs[i]++;
            }
            if (i + rs[i] > pr) {
                pr = i + rs[i];
                center = i;
            }
        }
        return rs;
    }

    private static char[] manachercs(String word) {
        char[] chars = word.toCharArray();
        char[] mchars = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != mchars.length; i++)
            mchars[i] = (i & 1) == 0 ? '#' : chars[index++];
        return mchars;
    }


}
