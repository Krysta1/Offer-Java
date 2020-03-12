/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 解题思路：
 * 1. 暴力求解：查看str1，str2长度的最大公约数，如果str1和str2能够同时被str1.substring(0, gcd)整除
 *    那么str1和str2的最大公因子就是str1.substring(0, gcd)，否则就是""。
 * 2. 数学性质：如果 str1 和 str2 拼接后等于 str2和 str1 拼接起来的字符串（注意拼接顺序不同），那么一定存在符合条件的字符串 X。
 *    而这个字符串一定是str1.substring(0, gcd)
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int gcd= gcd(l1, l2);
        String divider = str1.substring(0, gcd);
        // System.out.println(canDivide(str1, str2));
        if (canDivide(str1, divider) && canDivide(str2, divider)){
            return divider;
        }
        return "";
    }
    public int gcd(int a, int b){
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    public boolean canDivide(String s1, String s2){
        if (s1.length() % s2.length() != 0){
            return false;
        }
        int l = s2.length();
        for (int i = 0; i < s1.length(); i ++){
            if (s1.charAt(i) != s2.charAt(i % l)){
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int gcd = gcd(l1, l2);
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(l1, l2));
    }

    public int gcd(int a, int b){
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}