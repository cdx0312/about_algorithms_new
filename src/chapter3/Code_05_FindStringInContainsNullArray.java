package chapter3;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-25 20:43
 **/
public class Code_05_FindStringInContainsNullArray {
    private static int getIndex(String[] strings, String str) {
        if (strings == null ||strings.length == 0 || str == null)
            return -1;
        int res = -1;
        int left = 0;
        int right = strings.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strings[mid] != null && strings[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strings[mid] != null) {
                if (strings[mid].compareTo(str) < 0)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                i = mid;
                while (strings[i] == null && --i >= left)
                    ;
                if (i < left || strings[i].compareTo(str) < 0)
                    left = mid + 1;
                else {
                    res = strings[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[] { null, "a", null, "a", null, "b", null,
                null, null, "b", null, "c", null, "c", null, null, "d", null,
                null, null, null, null, "d", null, "e", null, null, "e", null,
                null, null, "f", null, "f", null };
        String str1 = "a";
        System.out.println(getIndex(strs, str1));
        String str2 = "b";
        System.out.println(getIndex(strs, str2));
        String str3 = "c";
        System.out.println(getIndex(strs, str3));
        String str4 = "d";
        System.out.println(getIndex(strs, str4));
        String str5 = "e";
        System.out.println(getIndex(strs, str5));
        String str6 = "f";
        System.out.println(getIndex(strs, str6));

    }
}
