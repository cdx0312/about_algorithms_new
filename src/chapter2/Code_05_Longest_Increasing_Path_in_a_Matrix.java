package chapter2;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 21:05
 **/
public class Code_05_Longest_Increasing_Path_in_a_Matrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(grid));
    }

    private static int longestIncreasingPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] h = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, maxIncrease(grid, h, i + 1, j, grid[i][j]) + 1);
                max = Math.max(max, maxIncrease(grid, h, i - 1, j, grid[i][j]) + 1);
                max = Math.max(max, maxIncrease(grid, h, i, j + 1, grid[i][j]) + 1);
                max = Math.max(max, maxIncrease(grid, h, i, j - 1, grid[i][j]) + 1);
            }
        }
        return max;
    }

    private static int maxIncrease(int[][] grid, int[][] h, int i, int j, int val) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] >= val)
            return 0;
        if (h[i][j] == 0) {
            h[i][j] = maxIncrease(grid, h, i + 1, j, grid[i][j]) + 1;
            h[i][j] = Math.max(h[i][j], maxIncrease(grid, h, i, j + 1, grid[i][j]) + 1);
            h[i][j] = Math.max(h[i][j], maxIncrease(grid, h, i - 1, j, grid[i][j]) + 1);
            h[i][j] = Math.max(h[i][j], maxIncrease(grid, h, i, j - 1, grid[i][j]) + 1);
        }
        return h[i][j];
    }
}
