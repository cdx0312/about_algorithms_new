package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 19:20
 **/
public class Code_04_Group_Anagrams {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strings));
        System.out.println(groupAnagrams2(strings));

    }

    private static List<List<String>> groupAnagrams1(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams2(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String string : strings) {
            int[] record = new int[26];
            for (char ch : string.toCharArray())
                record[ch - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int val : record) {
                sb.append(String.valueOf(val)).append("_");
            }
            String key = sb.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

}
