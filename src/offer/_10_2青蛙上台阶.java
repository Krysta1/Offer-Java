/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 解题思路：fn = fn-1 + fn-2。
 *          分析得知其实就是个斐波那契数列问题。
 */
class Solution {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for ( int i = 0; i < n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
