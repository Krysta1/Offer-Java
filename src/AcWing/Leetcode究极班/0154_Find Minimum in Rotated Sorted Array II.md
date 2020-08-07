#### 问题描述
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

    Input: [1,3,5]
    Output: 1
Example 2:

    Input: [2,2,2,0,1]
    Output: 0

#### 解题思路
加上了重复的元素，难度在于无法保证 nums[mid] == nums[0] 或者 nums[-1] 的时候无法确定答案在哪一边

所以首先将末位位置上与首位相等的元素去除掉，这样就能够判断出答案所在的位置。

借一个y总的图：

![explain](https://cdn.acwing.com/media/article/image/2019/11/20/1156_227d84760b-1_92f5550a64-2.png)
#### 代码 

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
            if nums == None or len(nums) == 0:
                return -1
            for i in range(1, len(nums)):
                if (nums[i] < nums[i - 1]):
                    return nums[i]
                
            return nums[0]
            
            
    class Solution:
        def findMin(self, nums: List[int]) -> int:
            if nums[-1] > nums[0]: return nums[0]
            
            left = 0
            right = len(nums) - 1
            
            t = right;
            while t > 0 and nums[t] == nums[0]: t -= 1
            right = t;
            
            while (left < right):
                mid = (left + right) // 2
                if (nums[mid] <= nums[t]): right = mid
                else: left = mid + 1
                    
            return nums[left]
            

#### 总结