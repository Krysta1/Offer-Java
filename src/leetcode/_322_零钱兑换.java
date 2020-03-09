/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 解题思路：
 * 1.dfs+剪枝：先将coins进行排序，然后从大到小进行dfs搜索。dfs(coins, amount, coins.length - 1, 0)
 *            对与每一个index都要确定最多可以有多少个coins[index]，然后将其一次递减，进行递归调用index-1
 *            同时要注意总和不要超过当前的最小值。dfs(coins, amount - i * coins[index], index - 1, res + i)
 * 2.动态规划：dp[amount + 1]
 *            这里要注意i >= coins[j]才去比较min
 *            dp[i] = min[dp[i - coins[0...coins.length]] + 1
 *            最后返回dp[amount]，如果没改变的话，返回-1。
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] res = new int[max];
        Arrays.fill(res, max);
        res[0] = 0;
        for (int i = 1; i < max; i ++){
            for (int j = 0; j < coins.length; j ++){
                if (i >= coins[j]){
                    res[i] = Math.min(res[i], res[i - coins[j]] + 1);
                }
            }
        }
        return res[amount] > amount ? -1 : res[amount];
    }
}

class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
         Arrays.sort(coins);
         dfs(coins, amount, coins.length-1, 0);
         if (ans == Integer.MAX_VALUE) return -1;
         return ans;
    }

    public void dfs(int[] coins, int amount, int index, int res){
        if (amount == 0) {
            ans = Math.min(res, ans);
            return;
        }
        if (index == -1 ) return;

        for (int i = amount / coins[index]; i >= 0 && i + res < ans; i --){
            dfs(coins, amount - i * coins[index], index - 1, res + i);
        }
    }
}