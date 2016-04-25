package leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p/>
 * Given target = 20, return false.
 * <p/>
 * Created by kevin on 2016/4/25.
 */
public class L240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            while (col > 0 && matrix[row][col] > target) col--;
            if (col == 0 && matrix[row][col] > target) break;
            while (row < matrix.length - 1 && matrix[row][col] < target) row++;
            if (row == matrix.length - 1 && matrix[row][col] < target) break;
        }
        return false;
    }
}
