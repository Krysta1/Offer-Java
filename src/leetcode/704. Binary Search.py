class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l, r = 0, len(nums)

        while l < r:
            mid = (r + l) // 2
            if nums[mid] == target:
                return mid

            elif nums[mid] > target:
                r = mid
            else:
                l = mid + 1

        return -1


# 经典二分模板，直接用y总的
s = Solution()
print(s.search([-1, 2, 3, 5, 6, 7, 8], 8))
