#### 问题描述

#### 解题思路

#### 代码

    class Solution:
        def majorityElement(self, nums: List[int]) -> int:
            tmp = nums[0]
            count = 1
            
            for i in range(1, len(nums)):
                if nums[i] == tmp:
                    count += 1
                else:
                    count -= 1
                
                if count == -1:
                    tmp = nums[i]
                    count = 0
                    
            return tmp
            
    #         dic = {}
            
    #         for num in nums:
    #             if num not in dic:
    #                 dic[num] = 1
    #             else:
    #                 dic[num] += 1
                    
    #             if dic[num] > len(nums) // 2:
    #                 return num
            
    #         return None

#### 总结