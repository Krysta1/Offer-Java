/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 解题思路：
 * 1.通过遇到的字符不断改变状态，根据状态进行判断。
 *      1> 如果是'-'或'+'，在索引>0的同时前一个字符不是e或者E的话，返回false
 *      2> 如果是'e'或'E'，如果之前出现过e或E，或者之前的字符不是数字的话返回false，这里注意更新遇到数字的状态为false
 *      3> 如果是'.'，最前遇到过.或者e和E，那么就返回false
 *      4> 如果是数字'0-9'，将遇到数字标记成true
 *      5> 其他直接返回false
 * 2.是数字的只会有两种情况，[A.[B]][e/E[C]] 或者 [.[B]][e/E[C]]
 *      其中AC是无整数，B是正整数
 *      首先有eE一定要有C，没有直接返回false
 *
 *      确认A，B的状态，如果最后没到字符串结尾，说明遇到了不合法的字符，在[e/E[C]]合法的情况下，
 *      确认A||B，即A存在，B有无皆可，但是A不存在，B一定要存在。
 */
class Solution {
    int i = 0;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        String str = s.trim();
        boolean a = isSigned(str), b = false, c = false;
        if (i < str.length() && str.charAt(i) == '.'){
            i ++;
            b = isUnsigned(str);
        }
        if (i < str.length() && (str.charAt(i) == 'e' || str.charAt(i) == 'E')){
            i ++;
            c = isSigned(str);
            if (c == false) return false;
        }
        return i == str.length() && (a || b);
    }

    public boolean isSigned(String str){
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) i ++;
        return isUnsigned(str);
    }

    public boolean isUnsigned(String str){
        int start = i;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            i ++;
        }
        return i > start;
    }
}

class Solution {
    int i = 0;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] str = s.trim().toCharArray();
         boolean metDot = false, metE = false, metDigit = false;
         for (int i = 0; i < str.length; i ++){
             if (str[i] >= '0' && str[i] <= '9'){
                 metDigit = true;
             }
             else if (str[i] == '-' || str[i] == '+'){
                 if (i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
             }
             else if (str[i] == 'e' || str[i] == 'E'){
                 if (metE || metDigit == false) return false;
                 metE = true;
                 metDigit = false;
             }
             else if (str[i] == '.'){
                 if (metDot || metE) return false;
                 metDot = true;
             }
             else{
                 return false;
             }
         }
         return metDigit;
    }
}