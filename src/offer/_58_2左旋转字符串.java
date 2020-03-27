/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 解题思路：
 * 1.将字符串转化成字符数组，首先复制前n个字符到新数组tmp，然后将前l-n个等于后l-n
 *   后面的一次将tmp数组放回去即可。
 * 2.或者使用substring，双百就离谱。
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        int l = s.length();
        if (n == 0) return s;
        char[] c = s.toCharArray();
        char[] tmp = new char[n];
        for (int i = 0; i < l; i ++){
            if (i < n){
                tmp[i] = c[i];
            }
        }
        for (int i = 0; i < l; i ++){
            if (i >= l - n){
                c[i] = tmp[i + n - l];
            }
            else{
                c[i] = c[i  + n];
            }
        }
        return new String(c);
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
