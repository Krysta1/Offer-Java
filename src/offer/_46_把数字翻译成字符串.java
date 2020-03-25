/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 解题思路：
 * 1.动态规划：
 *   如果前面i-1 和i位组成的数字在10-25中间，dp[i] = dp[i-1] + dp[i - 2]
 *   如果不在的话，dp[i] = dp[i-1]
 *   注意初始化时确定前两位，是不是在10-25之间。不过这样要转换成字符串来做，时间消耗比较大。
 * 2.直接使用数字进行递归。（从后向前）
 *   如果nums%100 也就是末两位在10-25之间，那个就要递归 返回num/10 和 num/100 的结果
 *   否则直接返回 num/10的结果即可。
 *   递归终止条件是：num <= 9；返回1。
 */
// 动态规划
class Solution {
    int res = 0;
    public int translateNum(int num) {
         String s = String.valueOf(num);
         if (s.length() <= 1) return s.length();
         int[] dp = new int[s.length()];
         dp[0] = 1;
         if (judge(Integer.valueOf(s.substring(0, 2)))) dp[1] = 2;
         else dp[1] = 1;
         for (int i = 2; i < s.length(); i ++){
             int tmp = Integer.valueOf(s.substring(i - 1, i + 1));
             System.out.println(tmp);
             if (tmp >= 10 && tmp <= 25){
                 dp[i] = dp[i - 1] + dp[i - 2];
             }
             else{
                 dp[i] = dp[i - 1];
             }
         }
         return dp[s.length() - 1];
    }

    public boolean judge(int a){
        if (a >= 10 && a <= 25){
            return true;
        }
        return false;
    }
}
// 数字递归
class Solution {
    int res = 0;
    public int translateNum(int num) {
        if (num <= 9) return 1;
        int mod = num % 100;
        if (mod <= 9 || mod >= 26) return translateNum(num/10);
        else return translateNum(num/10) + translateNum(num/100);
    }
}