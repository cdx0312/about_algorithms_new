import java.util.HashSet;
import java.util.Set;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 20:26
 **/
public class RemoveDupFromString {
    public static void main(String[] args) {
        System.out.println(removeDups("122233554884339"));
    }

    private static String removeDups(String string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if (!set.contains(string.charAt(i))) {
                sb.append(string.charAt(i));
                set.add(string.charAt(i));
            }
        }
        return sb.toString();
    }
}
