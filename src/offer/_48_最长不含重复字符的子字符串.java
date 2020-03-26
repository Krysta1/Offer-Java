/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 解题思路：
 * 1.动态规划：
 *   dp[i]  保存到当前位置的最长的不含重复的子字符串
 *   如果从0-（i-1）中有和 c[i]相同的元素，那么dp[i] = Min(dp[i-1]+1, i -j)
 *   如果没有 dp[i] = dp[i-1] + 1，自己写的时间复杂度有点高。时间超过5%。
 * 2.优化一下，使用HashMap保存一下上一次出现这个元素的位置。省去一次循环获取重复位置。
 * 3.滑动窗口：
 *   这里注意，向字典中存位置的时候可以直接存放j+1
 *   这样在确认位置的时候就不用额外处理了。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l <= 1) return l;
        int[] dp = new int[l+1];
        dp[0] = 1;
        char[] c = s.toCharArray();
        int res = 1;
        for (int i = 1; i < l; i ++){
            int j = i;
            for (j = i - 1; j >= 0; j--){
                if (c[j] == c[i]){
                    // System.out.println(i +","+ j + "出现重复，重置为i-j");
                    dp[i] = Math.min((i - j), dp[i - 1] + 1);
                    break;
                }
            }
            System.out.println(i + " " + j);
            if (j == -1 && c[0] != c[i]){
                // System.out.println(i+"," + j + "没有重复，+1");
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

// 优化一下，HashMap保存上一次出现当前元素的位置。
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l <= 1) return l;
        char[] c = s.toCharArray();
        int res = 0;
        int cur_res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i ++){
            if (!map.containsKey(c[i]) || i - map.get(c[i]) > cur_res){
                cur_res ++;
            }
            else{
                cur_res = i - map.get(c[i]);
            }
            map.put(c[i], i);
            res = Math.max(res, cur_res);
        }
        return res;
    }
}

// 滑动窗口
public class Solution {
    public  int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        //创建map窗口,i为左区间，j为右区间，右边界移动
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            ans = Math.max(ans, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }
}

