class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def dfs(nums, tmp):
            if not nums:
                res.append(tmp)
                return
            for i in range(len(nums)):
                if i > 0 and nums[i - 1] == nums[i]:
                    continue
                dfs(nums[:i] + nums[i + 1:], tmp + [nums[i]])

        res = []
        dfs(nums, [])
        return res
