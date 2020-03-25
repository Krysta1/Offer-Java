/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 解题思路：
 * 1.动态规划：
 *   数组dp，dp[i]用来保存nums到i位置时最大的子数组和。
 *   当dp[i-1]<0时，这对当前元素起副作用，等于当前元素即可。
 *   当dp[i-1]>=0时，就要更新dp[i] = dp[i-1] + nums[i]
 *   同时要记得使用一个res不断保存中间的最大值，因为最终结果不一定是dp[-1]
 *   一开始就犯了这个错误，研究了半天。。。
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i ++){
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i ++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }
            else{
                dp[i] = nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}