class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)

        if length < 3:
            return False

        for i in range(length):
            for j in range(i + 1, length):
                if nums[j] <= nums[i]:
                    continue
                for k in range(j + 1, length):
                    if nums[k] <= nums[i] or nums[k] >= nums[j]:
                        continue
                    else:
                        return True

        return False