/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]    给定 target = 5，返回 true。 给定 target = 20，返回 false。
 * 解题思路：
 * 1. 双层循环，暴力搜索。
 * 2. 从二维矩阵的右上角开始搜索，
 *    如果相等，返回true；如果matrix[i][j]>target的话，向左走，即j--；如果<的话，i++。
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        boolean res = false;
        if (m == 0) return res;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
             for (int j = 0; j < n; j ++){
                 if (matrix[i][j] == target){
                     return true;
                 }
             }
        }

        return false;
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        boolean res = false;
        if (m == 0) return res;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while ( i < m && j >= 0){
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }

        return false;
    }
}

