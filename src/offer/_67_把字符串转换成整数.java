/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 解题思路：
 */
class Solution {
    char[] numbers = new char[]{'0', '1','2','3','4','5','6','7','8','9'};
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1;
        boolean flag = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+'){
            flag = true;
            if (str.charAt(0) == '-'){
                sign = -1;
            }
        }
        String res = "";
        System.out.println(str);
        int l = str.length();
        for (int i = flag == true ? 1 : 0; i < l; i ++){
            char tmp = str.charAt(i);
            if (isNumber(tmp)){
                res += tmp;
            }
            else{
                break;
            }
        }
        if (res.length() == 0) return 0;
        if (Double.valueOf(res) > Integer.MAX_VALUE){
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        else return sign * Integer.valueOf(res);
    }


    public boolean isNumber(char c){
        for (char a: numbers){
            if (a == c){
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int strToInt(String str) {
        if(str==null||str.length()==0)return 0;
        int i=0;
        long ans=0;
        boolean isFu=false;
        while (i<str.length()&&str.charAt(i)==' ')i++; //过滤空格
        if (i<str.length()&&(str.charAt(i)=='+'||str.charAt(i)=='-'))  //正负号
        {
            if (str.charAt(i)=='-')isFu=true;
            i++;
        }
        for (; i <str.length()&&Character.isDigit(str.charAt(i)) ; i++) {

            ans=  ans*10+  str.charAt(i)-'0';

            long temp_ans=isFu?-ans:ans;

            if (temp_ans<=Integer.MIN_VALUE)return Integer.MIN_VALUE;
            if (temp_ans>=Integer.MAX_VALUE)return Integer.MAX_VALUE;

        }
        return  (int) (isFu? -ans:ans);
    }
}