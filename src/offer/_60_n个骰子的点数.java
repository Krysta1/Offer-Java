/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 1.动态规划：
 *   dp[i][j] 代表投掷玩第i个骰子之后，出现点数和为j的次数
 *   dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ...... + dp[i - 1][j - 5] + dp[i - 1][j - 6]
 * 2.递归+记忆化搜索
 *
 */
// 动态规划
class Solution {
    public double[] twoSum(int n) {
        int[][] dp = new int[12][70];
        for (int i = 1; i <= 6; i ++) dp[1][i] = 1;

        for (int i = 2; i <= n; i ++){
            for (int j = i; j <= 6 * i; j ++){
                for (int k = 1; k <= 6; k ++){
                    if ((j - k) <= 0) break;
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        int total = (int)Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i ++){
            res[i-n] = dp[n][i] * 1.0 / total;
        }
        return res;
    }
}
// 递归+记忆化搜索
class Solution {
    int[][] memo = new int[12][70];
    public double[] twoSum(int n) {
        int total = (int)Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i ++){
            res[i-n] = getCount(n, i) * 1.0 / total;
        }
        return res;
    }

    public int getCount(int n, int k){
        if (n == 1) return 1;
        if (memo[n][k] != 0) return memo[n][k];
        int res = 0;
        for (int i = 1; i <= 6; i ++){
            if ((k - i) > 0 && (k - i) <= 6 * (n - 1)){
                res += getCount(n - 1, k - i);
            }
        }
//        System.out.println(res);
        memo[n][k] = res;
        return res;
    }
}