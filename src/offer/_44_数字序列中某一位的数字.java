/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 输入：n = 3
 * 输出：3
 * 解题思路：
 * 1.找规律：先把特殊的0先拿出来。
 *   1-9 一共 9个数字，共占1*9 = 9位
 *   10-99 一共90个数字，共占2*90 = 180位
 *   100-999 一共900个数字，共占3*900 = 2700位
 *   总计下来，其实是10^base * (base + 1)
 *   根据上述规律先确定数字处于的区间，然后根据剩余的位数和base来确定具体的哪个数字的哪一位。
 * 注意：卡了好久没过，问题居然是
 * (int)(Math.pow(10, power - 1) * 9 * power) 和 (int)(Math.pow(10, power - 1)) * 9 * power的区别
 */
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int count = 0;
        int power = 1;
        while (n > 0){
            if (power == 1) count = 10;
            else count = (int)(Math.pow(10, power - 1) * 9 * power);
            // System.out.println(count);
            n -= count;
            power ++;
        }
        n += count;
        power --;
        // System.out.println(power);
        // System.out.println(n);
        int mod = n % power;
        int div = n / power;
        int res;
        res = (int)Math.pow(10, power - 1) + div;
        return String.valueOf(res).charAt(mod) - '0';
    }
}