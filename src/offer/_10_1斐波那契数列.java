/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 解题思路：方法真的有很多，自己使用了递归加记忆化搜索。
 * 1.递归加记忆化搜索：直接递归求值，肯定超时，所以用一个数组保存了计算结果，避免了大量重复的计算。
 * 2.直接迭代：在数组中，一次计算，i = i-1 + i-2
 * 3.节约空间的迭代方法：参考leetcode题解，位运算还是比较有意思的，一直用不好。如果不使用位运算，可以用两个变量来计算交换值。
 * int fib(int n) {
 *     int arr[2] = {0, 1} ;
 *     for (int i = 2; i <= n; ++i)
 *         arr[i&1] = (arr[(i-1)&1] + arr[(i-2)&1])%1000000007 ;
 *     return arr[n&1] ;
 * }
 * 作者：zouwx2cs
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-wen-ti-de-si-chong-jie-fa-by-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    int[] memo = new int[10000];
    public Solution(){
        memo[0] = 0;
        memo[1] = 1;
    }

    public int fib(int n) {
        if (memo[n] != 0 || n == 0) return memo[n];
        else memo[n] = (fib(n-1) + fib(n-2)) %1000000007;
        return memo[n];
        // for (int i = 2; i <= n; i ++){
        //     memo[i] = (memo[i-1] + memo[i-2]) % 1000000007;
        // }
        // return memo[n];
//        int a = 0, b = 1, sum;
//        for (int i = 0; i < n; i ++){
//            sum = (a + b) % 1000000007;
//            a = b;
//            b = sum;
//        }
    }
}

