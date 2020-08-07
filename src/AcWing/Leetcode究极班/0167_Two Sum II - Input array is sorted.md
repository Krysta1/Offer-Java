#### 问题描述

#### 解题思路

#### 代码

    class Solution:
        def twoSum(self, nums: List[int], target: int) -> List[int]:
            l = 0
            r = len(nums) - 1
            while l < len(nums) - 1 and r > 0:
                if (nums[l] + nums[r] < target):
                    l += 1
                elif (nums[l] + nums[r] > target):
                    r -= 1
                else:
                    return [l + 1, r + 1]
            
            return None

#### 总结