/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 解题思路：
 * 1.动态规划：
 *   选择左方或者上方最大的元素，+grid[i][j]即可。
 *   注意动态规划的题目，可以将dp数组多1个维度，这样可以省去初始化的循环过程，看起来简洁些。
 *   可以将二维数组，优化成一位的dp数组。
 * 2.也可以使用递归加记忆化搜索的方式通过。
 * 3.也可以原地在grid上修改，不占用额外空间。
 */
// 二维需要特殊初始化
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

         dp[0][0] = grid[0][0];
         for (int i = 1; i < n; i ++){
             dp[0][i] = dp[0][i-1] + grid[0][i];
         }
        for (int i = 1; i < m; i ++){
            for (int j = 0; j < n; j ++){
                 if (j == 0){
                     dp[i][j] = dp[i-1][j] + grid[i][j];
                 }
                 else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]) + grid[i][j];
                 }
            }
        }
        return dp[m-1][n-1];
    }
}
// 二维不需要特殊初始化
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[m][n];
    }
}
// 一维不需要初始化
class Solution {
    public int maxValue(int[][] grid) {
         int[] dp = new int[n + 1];
         for (int i = 0; i < m; i ++){
             for (int j = 0; j < n; j ++){
                 dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j];
             }
         }
         return dp[n];
    }
}