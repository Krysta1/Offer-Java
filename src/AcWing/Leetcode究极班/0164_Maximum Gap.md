#### 问题描述
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

    Input: [3,6,9,1]
    Output: 3
    Explanation: The sorted form of the array is [1,3,6,9], either
                 (3,6) or (6,9) has the maximum difference 3.
Example 2:

    Input: [10]
    Output: 0
    Explanation: The array contains less than 2 elements, therefore return 0.

#### 解题思路
首先肯定要排序，但是又不能使用基于比较的排序方法，最低的时间复杂度是 n*log(n)

使用桶排序，但是如何分区间是个问题。这里使用了鸽笼原理来证明。

对于n个数，会有n - 1个区间存在，我们将区间均分，gap = max - min / (n - 1) 向上取整保证可以放下所有的元素。

这样就划分成：

    [Min,Min + gap)
    [Min + gap,Min + 2 * gap)
    ...
    [Min + (n - 2) * gap,Min + (n - 1) * gap)
    [Min + (n - 1) * gap,Min + n * gap) 这个区间内只可能有Max。
    
去掉 min 和 max 两个元素，和最后一个区间，需要在 n - 1 个区间上 放下 n - 2 个元素， 也就是说中间肯定会有一个区间不存在元素。那么，在
这个区间的两侧的区间，两者的间距一定是大于 gap 的。

定义区间的形式为，[min, max] min是区间中的最小值，max是区间中的最大值，不断更新区间，最后去掉不存在元素的区间，再计算两个相邻区间的间隔中的最大值即可。

#### 代码

    class Solution:
        def maximumGap(self, nums: List[int]) -> int:
            if len(nums) < 2 or min(nums) == max(nums):
                return 0
            
            minNum = min(nums)
            maxNum = max(nums)
            
            size = (maxNum - minNum) // (len(nums) - 1) or 1
            
            batch = [[None, None] for _ in range((maxNum - minNum) // size + 1)]
            
            for num in nums:
                b = batch[(num - minNum) // size]
                b[0] = num if b[0] is None else min(b[0], num)
                b[1] = num if b[1] is None else max(b[1], num)
                
            batch = [b for b in batch if b[1] is not None]
            
            return max(batch[i][0] - batch[i - 1][1] for i in range(1, len(batch)))

#### 总结
一些直接初始化列表的方法可以学习一下：

    batch = [[None, None] for _ in range((maxNum - minNum) // size + 1)]
    
    batch = [b for b in batch if b[1] is not None]
    
    max(batch[i][0] - batch[i - 1][1] for i in range(1, len(batch)))
        