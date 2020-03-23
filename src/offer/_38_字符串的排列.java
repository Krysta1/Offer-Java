/**
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