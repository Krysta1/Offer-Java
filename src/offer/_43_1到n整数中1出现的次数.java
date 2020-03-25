/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次
 * 解题思路：
 * 1.暴力解法：
 *   对每个数都循环除10看个位数是不是1，并累计出现1的次数。
 *   对1-n每个数都循环一遍，就可以得到所有出现1的次数。
 * 2.递归思想：
 *   对于一个数字，可以分成两部分来考虑：
 *   当首位为1的时候，比如1234：1-999  和 1000 - 1234
 *   1-999即helper(999)
 *   1000-1234 千位为1的情况下，出现了234 + 1次
 *   剩下的是1-234中出现1的次数，即helper(234)
 *   当首位数字不为1的时候：比如3234，这时候可以分成1-999 1000-1999 2000-2999 3000-3234
 *   1-999 是helper(999)
 *   1000-1999 是power + helper(999)
 *   2000-2999 是helper(999)
 *   3000-3234 是helper(last)  总计就是power + high * helper(999) + helper(last)
 *   其中high代表高位数字，last代表除高位以外剩余尾数。
 */
class Solution {
    public int countDigitOne(int n) {
        return helper(n);
    }

    public int helper(int n){
        if (n <= 0){
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int)Math.pow(10, s.length() - 1);
        int last = n - pow * high;
        if (high == 1){
            return helper(pow - 1) + helper(last) + last + 1;
        }
        else{
            return pow + high * helper(pow - 1) + helper(last);
        }
    }
}