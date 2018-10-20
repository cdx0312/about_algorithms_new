package leetcode.array;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 16:58
 **/
public class _1BitAnd2BitCharacters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        boolean val = true;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i++;
                val = false;
            } else {
                val = true;
            }
        }
        return val;
    }
}
