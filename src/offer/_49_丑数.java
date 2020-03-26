/**
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 解题思路：
 * 1.神他妈的动态规划，三指针。
 *   dp[i] = min(2 * d2, 3 * d3, 5 * d5)
 *   并根据取值，相对应更新d2，d3，d5
 */

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[1700];
        dp[0] = 1;
        int d2 = 0, d3 = 0, d5= 0;
        for (int i = 1; i < n; i ++){
            dp[i] = Math.min(2 * dp[d2], Math.min(3 * dp[d3], 5 * dp[d5]));

            if (dp[i] == 2 * dp[d2]) d2 ++;
            if (dp[i] == 3 * dp[d3]) d3 ++;
            if (dp[i] == 5 * dp[d5]) d5 ++;
        }
        return dp[n - 1];
    }
}
