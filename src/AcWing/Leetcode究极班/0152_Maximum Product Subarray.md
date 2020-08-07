#### 问题描述
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

    Example 1:
    
    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
    Example 2:
    
    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

#### 解题思路
动态规划：

同时保存当前位置的最大值f和最小值g；

f(i) g(i) 代表在到 i 位置能够取得的乘积的最大值和最小值。

更新规则：

如果 nums[i] 是一个正数的话，f(i) = f(i - 1) * nums[i]；如果是负数的话，f(i) = g(i - 1) * nums[i]，当然也有可能是 nums[i]，比如在nums[i - 1] = 0 的时候

对于g(i) 的更新同理。

可以发现，对于f(i) 可以直接计算 f(i - 1) * nums[i]  g(i - 1) * nums[i] 和 nums[i]的最大值

g(i) 可以直接计算三者的最小值。

i位置  只和 i - 1 有关，所以可以使用滚动数组来保存，两个变量就够了。

#### 代码

    class Solution:
        def maxProduct(self, nums: List[int]) -> int:
            res, f, g = nums[0], nums[0], nums[0]
            
            for i in range(1, len(nums)):
                a = nums[i]
                fa = f * a
                ga = g * a
                
                f = max(a, max(fa, ga))
                g = min (a, min (fa, ga))
                
                res = max (f, res)
                
            return res

#### 总结