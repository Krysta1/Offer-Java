/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 解题思路：
 * 1.循环右移：每次和1做“与”运算，再右移一次。并统计结果为1的次数。
 * 2.利用n & (n-1)的性质：n & (n-1)可以将n二进制表示中最右边的1变成0。
 *      多次循环直到n为0。能够减少循环次数，提高效率。
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}