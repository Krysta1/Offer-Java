/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 解题思路：
 * 1.使用语言特性。&& || 短路与 和 短路或
 *   比如a && b 如果a为否，就不会去计算b的具体值。
 *   n>0时，就不去执行 && 后面的语句。
 *   知道n == 0时，才执行
 *   相当于 使用短路与执行了递归出口条件。
 *   因为Java的特性，必须得赋一个值。
 */

class Solution {
    public int sumNums(int n) {
        boolean b = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }
}