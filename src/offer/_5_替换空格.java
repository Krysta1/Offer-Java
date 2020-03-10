/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 解题思路：开一个字符串数组，长度为原字符串的三倍大小。
 *          使用charAt()完成字符串的遍历，如果遇到空格，一次添加'%20'
 *          如果不是直接修改到数组中值即可。
 *          使用一个count值记录当前的索引值。
 */
class Solution {
    public String replaceSpace(String s) {
        int l = s.length();
        char[] res = new char[3 * l];
        int count = 0;
        for ( int i = 0; i < l;i ++){
            char c = s.charAt(i);
            if (c == ' '){
                res[count++] = '%';
                res[count++] = '2';
                res[count++] = '0';
            }
            else{
                res[count++] = c;
            }
        }
        String ans = new String(res, 0, count);
        return ans;
    }
}