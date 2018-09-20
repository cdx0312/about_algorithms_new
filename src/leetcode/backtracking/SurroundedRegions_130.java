package leetcode.backtracking;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class SurroundedRegions_130 {
    int m;
    int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        //从最外圈寻找O,找到之后dfs标记与O相连的O
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }
        //修改
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'Z'){
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;
        board[i][j] = 'Z';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
