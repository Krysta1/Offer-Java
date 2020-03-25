/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * 解题思路：
 * 1.暴力搜索：
 * 2.
 */
// 暴力搜索
class Solution {
    public char firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        if (ss.length == 0) return ' ';
        for (int i = 0; i < ss.length; i ++){
            boolean flag = false;
            for (int j = 0; j < ss.length; j ++){
                if (i != j && ss[i] == ss[j]){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return ss[i];
            }
        }
        return ' ';
    }
}

// 用数组模拟map
class Solution {
    public char firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        if (ss.length == 0) return ' ';
        int[] count = new int [1000];
        for (char c: ss){
            // System.out.println((int)c);
            count[(int)c] ++;
        }
        // System.out.println(count);
        char res = ' ';
        for (char c: ss){
            if (count[(int)c] == 1){
                res = c;
                break;
            }
        }
        return res;
    }
}