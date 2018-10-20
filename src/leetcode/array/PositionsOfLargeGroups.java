package leetcode.array;

import java.util.*;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 17:55
 **/
public class PositionsOfLargeGroups {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        System.out.println(new PositionsOfLargeGroups().largeGroupPositions(s));
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int len = S.length();
        int i = 0;
        int j = 0;
        while (i < len) {
            while (j + 1 < len && S.charAt(j) == S.charAt(j+1))
                j++;
            if (j - i + 1 >= 3)
                res.add(Arrays.asList(i, j));
            j++;
            i = j;
        }
        return res;
    }
}
