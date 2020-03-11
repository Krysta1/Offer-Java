/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 解题思路：
 * 1.dfs要结合记忆化搜索，否则会有大量的重复计算导致超时。
 * 2.动态规划：
 *      dp[i] = max(dp[i], j * dp[i - j], j * (i - j))
 *      分别对应，状态不变，j和剩下的进行拆分，j和剩下的不拆分。
 * 3.贪心思想：
 *      通过分析，分割成3性价比最高，其次是2,1.
 *
 */
class Solution {
    public int cuttingRope(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for ( int i = 3; i <= n; i ++ ){
            int max = Integer.MIN_VALUE;
            for ( int j = 1; j < i; j ++){
                int tmp = Math.max(j * dp[i - j], j * (i - j));
                max = Math.max(max, tmp);
            }
            dp[i] = max;
        }
        return dp[n];
        // return dfs(n);
    }

    public int max( int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }

    public int dfs(int n){
        if (n == 1 || n == 2) return 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i ++){
            max = Math.max(Math.max(i * dfs(n - i), i* (n-i)), max);
        }
        return max;
    }
}

class Solution {  // 贪心求解方法。
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3 - 1, b = n % 3;
        if (b == 0) return (int)Math.pow(3, a);
        if (b == 1) return (int)Math.pow(3, a) * 4;
        return (int)Math.pow(3, a) * 6;
    }
}