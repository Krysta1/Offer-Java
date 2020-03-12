/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 解题思路：
 * 1.递归解法：如果n是偶数，直接返回，pow(base, n/2) * pow(base, n/2);
 *          如果n是奇数，则返回pow(base, n/2) * pow(base, n/2) * base;
 *          同时注意如果exponent是负数的话，在调用函数时，记得将base变成1/base, n变成-n就可以了。
 * 2.位运算解法：可以将n当做一个二进制数来看待。
 *          例如5可以看成101，可以看成3^1 * 3^4
 *
 */
class Solution {
    public double helper(double x, int N){
        if (N == 0) return 1;

        double half = helper(x, N / 2);
        if (N % 2 == 0){
            return half * half;
        }
        else{
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            N = -N;
            x = 1 / x;
        }
        return helper(x, N);
    }
}

public class Solution {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }

        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }

            x *= x;
            N >>>= 1;
        }
        return res;
    }
}

//作者：liweiwei1419
//链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/di-gui-xie-fa-fen-zhi-si-xiang-yu-fei-di-gui-xie-f/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。