#### 问题描述
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 1 or 5 
    Explanation: Your function can return either index number 1 where the peak element is 2, 
                 or index number 5 where the peak element is 6.

#### 解题思路
1. 二分递归写法，硬搜

2. 二分循环写法：
 
 如果 mid > mid - 1: 如果接下来的所有元素时单调的，n - 1 就是峰值...接下来不是单调的话，也就是说明后面第一个 i > i + 1的就是峰值
 
 同理可得，在mid <= mid - 1 时，也可以证明 左半部分存在峰值。

#### 代码

    class Solution:
        
        def findPeakElement(self, nums: List[int]) -> int:
            self.res = 0
            n = len(nums)
            if n == 2:
                return 1 if nums[1] > nums[0] else 0
            elif n < 1:
                return 0
            else:
                self.binarySearch(nums, 0, n - 1)
                return self.res
        
        
        def binarySearch(self, nums, left, right):
            if left >= right:
                if left == right:
                    if left == 0 and len(nums) > 1 and nums[0] > nums[left + 1]:
                        self.res = left
                    elif left == len(nums) - 1 and nums[left] > nums[left - 1]:
                        self.res = left
                    elif nums[left] > nums[left - 1] and nums[left] > nums[left + 1]:
                        self.res = left
                    return
                else:
                    return
            
            mid = int ((left + right) / 2)
            if mid == 0 and nums[0] > nums[1]:
                self.res = mid
            elif mid == len(nums) - 1 and nums[mid] > nums[mid - 1]:
                self.res = mid
            elif nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                self.res = mid
            
            else:
                self.binarySearch(nums, left, mid)
                self.binarySearch(nums, mid + 1, right)
                
    
    class Solution:
        
        def findPeakElement(self, nums: List[int]) -> int:
            l = 0
            r = len(nums) - 1
            while (l < r):
                mid = (l + r + 1) // 2
                if (nums[mid] > nums[mid - 1]): l = mid
                else: r = mid - 1 
            return l

#### 总结
脑子进水了？非要写递归版本的
