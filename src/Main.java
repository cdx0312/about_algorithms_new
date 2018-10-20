import java.util.*;

public class Main {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(new StringBuilder(), 0, s, 0, 0);
        return res;
    }

    /**
     * DFS方法，回溯法应用
     * @param sb 拼接的字符串
     * @param pos 字符串的下标
     * @param s 输入的字符串
     * @param num 组成的数字
     * @param dot 点的个数
     */
    private void dfs(StringBuilder sb, int pos, String s, int num, int dot) {
        if (pos == s.length()) {
            if (dot == 3)
                res.add(sb.toString());
            return;
        }

        if (num * 10 + s.charAt(pos) - '0' <= 25) {
            if (pos == 0 || num != 0) {
                sb.append(s.charAt(pos));
                dfs(sb, pos + 1, s, num * 10 + s.charAt(pos)-'0', dot);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (dot < 3 && pos > 0) {
            sb.append(".");
            sb.append(s.charAt(pos));
            dfs(sb, pos + 1, s, s.charAt(pos) - '0', dot + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}