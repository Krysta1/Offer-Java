#### 问题描述
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

    Input: [3,4,5,1,2] 
    Output: 1
Example 2:

    Input: [4,5,6,7,0,1,2]
    Output: 0

#### 解题思路
1. 二分的思想去递归查找。

2. 傻子一样，为啥去递归呢...直接二分啊

#### 代码
    
    #  二分的思想去递归查找
    class Solution:
        
        def findMin(self, nums: List[int]) -> int:
            self.nums = nums
            self.res = nums[0]    
            self.findMinHelper(self.nums, 0, len(nums) - 1)
            return self.res
        
        def findMinHelper(self, nums, left, right):
            if left >= right:
                # return
                if left == right:
                    if left > 0 and nums[left] < nums[left - 1]:
                        self.res = nums[left]
                    return
                else:
                    return
            
            mid = int((left + right) / 2)
            if mid > 0 and nums[mid] < nums[mid - 1]:
                self.res = nums[mid]
                
            else:
                self.findMinHelper(nums, left, mid)
                self.findMinHelper(nums, mid + 1, right)
                
    # 二分
    class Solution:
        
        def findMin(self, nums: List[int]) -> int:
            if nums[-1] > nums[0]: return nums[0]
            
            left = 0
            right = len(nums) - 1
            
            while (left < right):
                mid = (left + right) // 2
                if (nums[mid] >= nums[0]): left = mid + 1
                else: right = mid
                    
            return nums[left]
        

#### 总结
真的蠢，为什么要写递归？？？？

二分模板真香    (l + r) // 2   right = mid (// 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用)
(l + r + 1 // 2)   left = mid  (// 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：)