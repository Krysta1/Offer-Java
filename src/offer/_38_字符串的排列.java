/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 解题思路：
 * 1.交换的思路：
 *   先将字符串转化成字符串矩阵，从当前位置到字符串结尾进行交换，比如123  将23进行交换得到132 其实就是一种原字符串的排列。
 *   但是这里要注意，由于字符串矩阵是没有经过排序的。
 *   所以如果在pos和i之间存在和i位置一致的元素，就不用进行交换了。 1233345  pos=2 i=4的时候，当i=3时已经进行过交换。
 *   如果i=4再进行交换的话，就会出现重复的情况。
 * 2.将字符串排序之后(helper函数)，并使用一个visited矩阵来标记访问过的位置。
 *   递归出口：result的长度 = s的长度时，就可以将答案添加到最终结果中。
 *   递归过程：如果当前访问的字符和前面的字符一致，并且前一个字符没有使用过，直接continue（这里很关键），主要用来去重
 *   如果当前的字符被访问过，continue。
 *   剩下的就是更改访问状态，递下一个状态。然后恢复状态。
 *
 */
import java.util.Collections;
class Solution {
    List<String> res= new ArrayList<>();
    public String[] permutation(String s) {
        // boolean[] visited = new boolean[s.length()];
        char[] arrayChar = s.toCharArray();
        // Arrays.sort(arrayChar);
        // helper(arrayChar, "", visited);
        dfs(arrayChar, 0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(char[] s, int pos){
        if (pos >= s.length){
            res.add(String.valueOf(s));
            return;
        }
        for (int i = pos; i < s.length; i ++){
            if (judge(s, pos, i)) continue;
            char tmp = s[i];
            s[i] = s[pos];
            s[pos] = tmp;
            dfs(s, pos + 1);
            tmp = s[i];
            s[i] = s[pos];
            s[pos] = tmp;
        }
    }

    public boolean judge(char[] s, int start, int end){
        for (int i = start; i < end; i ++){
            if (s[i] == s[end]){
                return true;
            }
        }
        return false;
    }

    public void helper(char[] s, String result, boolean[] visited){
        if (result.length() == s.length){
            res.add(result);
            return;
        }
        for (int i = 0; i < s.length; i ++){
            if (i > 0 && s[i] == s[i - 1] && !visited[i - 1]) continue;
            if (visited[i]) continue;
            char c = s[i];
            visited[i] = true;
            helper(s, result + String.valueOf(c), visited);
            visited[i] = false;
        }
    }
}