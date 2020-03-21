/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 解题思路：
 * 1.递归求解：
 *      首先判断特殊情况，如果p为空，s也为空则匹配；如果s不为空则不匹配。
 *      下面主要对p模式第二个字符进行考虑。
 *      如果是*的话：
 *          1. 第一种情况是不管*加上前面的字母，比如：bb 和 a*bb是匹配的。
 *          2. 第二种情况是管*前面的字母，这个时候就要求s[0] == p[0]或者p[0] == '.'（是一个通配符），
 *             这个时候要继续向下s要继续向下考虑，而p不动，即继续比较s[1:]和p。比如：aaabbb 和 a*bbb是匹配的
 *      不过不是*
 *          1. 直接看s[0] == p[0]或者p[0] == '.'
 *          2. 继续向下递归比较s[1:]和p[1:]
 * 2.动态规划：
 *      状态转移基本与递归方法中类似。
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            if (s.length() == 0) return true;
            else return false;
        }

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || ((s.length() != 0) &&
                    (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) &&
                    isMatch(s.substring(1), p);
        }
        else{
            return (s.length() != 0) &&
                    (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                    (isMatch(s.substring(1), p.substring(1)));
        }
    }
}