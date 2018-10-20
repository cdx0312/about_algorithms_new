package leetcode.array;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-10-20 16:49
 **/
public class ToeplitzMatrix_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}