/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 解题思路：
 * 1.简单的思想就是，遇到走不了的地方就换方向，换方向的顺序是，下，左，上，右。如果访问的元素不在矩阵范围内，或者已经被访问过了，
 * 那就转变方向。
 * 2.设定四个方向的边界，每次循环完一个方向记得更新边界值。t，r，b，l四个方向。
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[]{};
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int top = 0, right = n - 1, bottom = m - 1, left = 0;
        int index = 0;
        while (true){
            for (int i = left; i <= right; i ++) res[index++] = matrix[top][i];
            if (++ top > bottom) break;
            for (int i = top; i <= bottom; i ++) res[index++] = matrix[i][right];
            if (-- right < left) break;
            for (int i = right; i >= left; i --) res[index++] = matrix[bottom][i];
            if (-- bottom < top) break;
            for (int i = bottom; i >= top; i --) res[index++] = matrix[i][left];
            if (++ left > right) break;
        }
        return res;
    }
}

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[]{};
        int n = matrix[0].length;
        int[] res = new int[m * n];
         boolean[][] seen = new boolean[m][n];
         int[] dr = {0, 1, 0, -1};
         int[] dc = {1, 0, -1, 0};
         int r = 0, c = 0, di = 0;
         for (int i = 0; i < m * n; i ++){
             res[i] = matrix[r][c];
             seen[r][c] = true;
             int next_r = r + dr[di];
             int next_c = c + dc[di];
             if (next_r >= 0 && next_r < m && next_c >= 0 && next_c < n && seen[next_r][next_c] == false){
                 r = next_r;
                 c = next_c;
             }
             else{
                 di = (di + 1) % 4;
                 r += dr[di];
                 c += dc[di];
             }
         }
        return res;
    }
}