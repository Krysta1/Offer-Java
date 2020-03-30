/**
 * 总结下所有的股票利润的题目。
 * 参考以下链接：
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 *    题目            交易次数    冻窗期     手续费
 * leetcode 121         1         无         无
 * leetcode 122        多次        无         无
 * leetcode 123        两次        无         无
 * leetcode 188         k次        无         无
 * leetcode 309        多次      有(一天)     无
 * leetcode 714        多次      有(一天)     有
 *
 * 要求不能在买入之前卖出，必须在再次购买前出售掉之前的股票，冻窗期的含义是卖出之后有一定时间不能够进行买入
 * 手续费很好理解就是卖出的时候，要支付一定的钱，要在利润中扣除。
 *
 * 利用「状态」进行穷举。我们具体到每一天，看看总共有几种可能的「状态」，再找出每个「状态」对应的「选择」。我们要穷举所有「状态」，
 * 穷举的目的是根据对应的「选择」更新状态。听起来抽象，你只要记住「状态」和「选择」两个词就行，下面实操一下就很容易明白了。
 * for 状态1 in 状态1的所有取值：
 *     for 状态2 in 状态2的所有取值：
 *         for ...
 *             dp[状态1][状态2][...] = 择优(选择1，选择2...)
 *
 * 每天都有三种「选择」：买入、卖出、无操作，我们用 buy, sell, rest 表示这三种选择。
 * 但问题是，并不是每天都可以任意选择这三种选择的，因为 sell 必须在 buy 之后，buy 必须在 sell 之后。
 * 那么 rest 操作还应该分两种状态，一种是 buy 之后的 rest（持有了股票），一种是 sell 之后的 rest（没有持有股票）。
 * 而且别忘了，我们还有交易次数 k 的限制，就是说你 buy 还只能在 k > 0 的前提下操作。
 *
 * 这个问题的「状态」有三个，第一个是天数，第二个是允许交易的最大次数，
 * 第三个是当前的持有状态（即之前说的 rest 的状态，我们不妨用 1 表示持有，0 表示没有持有）。
 * 然后我们用一个三维数组就可以装下这几种状态的全部组合：
 * dp[i][k][0 or 1]
 * 0 <= i <= n-1, 1 <= k <= K
 * n 为天数，大 K 为最多交易数
 * 此问题共 n × K × 2 种状态，全部穷举就能搞定。
 * for 0 <= i < n:
 *     for 1 <= k <= K:
 *         for s in {0, 1}:
 *             dp[i][k][s] = max(buy, sell, rest)
 *
 * 比如说 dp[3][2][1] 的含义就是：今天是第三天，我现在手上持有着股票，至今最多进行 2 次交易。
 *
 * 最终答案是 dp[n - 1][K][0]，即最后一天，最多允许 K 次交易，最多获得多少利润。
 *
 * 状态转移：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *               max(   选择 rest  ,           选择 sell      )
 *
 * 解释：今天我没有持有股票，有两种可能：
 * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
 * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
 *
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *               max(   选择 rest  ,           选择 buy         )
 *
 * 解释：今天我持有着股票，有两种可能：
 * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
 * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
 *
 * base case:
 * dp[-1][k][0] = 0
 * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
 * dp[-1][k][1] = -infinity
 * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
 * dp[i][0][0] = 0
 * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
 * dp[i][0][1] = -infinity
 * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
 *
 * 总结一下：
 * base case：
 * dp[-1][k][0] = dp[i][0][0] = 0
 * dp[-1][k][1] = dp[i][0][1] = -infinity
 *
 * 状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 */

// leetcode 121
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++){
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}

// leetcode 122
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++){
            int tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmp - prices[i]);
        }
        return sell;
    }
}

// leetcode 123
class Solution {
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int n = prices.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < prices.length; i ++){
            for (int k = max_k; k >= 1; k --){
                if (i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                }
                else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }

            }
        }
        return dp[n-1][max_k][0];
    }
}

// leetcode 188
class Solution {
    public int maxProfit(int j, int[] prices) {
        int max_k = j;
        int n = prices.length;
        if (n == 0) return 0;
        if (max_k > n / 2) return maxProfitInfinity(prices);
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < prices.length; i ++){
            for (int k = max_k; k >= 1; k --){
                if (i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                }
                else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }

            }
        }
        return dp[n-1][max_k][0];
    }

    public int maxProfitInfinity(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++){
            int tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmp - prices[i]);
        }
        return sell;
    }
}

// leetcode 309
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < prices.length; i ++){
            int tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, pre - prices[i]);
            pre = tmp;
        }
        return sell;
    }
}

// leetcode 714
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++){
            int tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmp - prices[i] - fee);
        }
        return sell;
    }
}
