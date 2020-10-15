class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        res = []
        tmp = []
        if k == 0 or len(nums) == 0:
            return []

        k = k % len(nums)

        for i in range(len(nums)):
            if i < (len(nums) - k):
                tmp.append(nums[i])
            else:
                res.append(nums[i])
        res += tmp
        for i in range(len(nums)):
            nums[i] = res[i]


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        def reverse(nums, l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1

        if k == 0 or len(nums) == 0:
            return []
        k = k % len(nums)
        reverse(nums, 0, len(nums) - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)
