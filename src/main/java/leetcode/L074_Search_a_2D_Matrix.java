package leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * <p/>
 * Created by kevin on 2016/4/24.
 */
public class L074_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int line = matrix.length - 1;
        for (; line > 0; line--) {
            if (matrix[line][0] <= target) break;
        }
        int col = matrix[0].length - 1;
        if (matrix[line][col] < target) return false;
        int left = 0, right = col;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[line][mid] < target) {
                left = mid + 1;
            } else if (matrix[line][mid] > target) {
                right = mid -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
