import time


class Solution(object):
    def firstMissingPositive(self, nums):
        l = len(nums)
        if l == 0:
            return 1
        if l == 1 and nums[0] == 1:
            return 2
        if l == 1 and nums[0] != 1:
            return 1
        for i, num in enumerate(nums):
            while nums[i] != i + 1:
                if 0 < nums[i] < l and nums[nums[i]-1] != nums[i]:
                    tmp = nums[i]-1
                    nums[i], nums[tmp] = nums[tmp], nums[i]
                    # print(nums)
                    # time.sleep(1)
                else:
                    break

        for i in range(l):
            if nums[i] != i + 1:
                return i + 1
        return l + 1


s = Solution()
print(s.firstMissingPositive([7,8,9,11,12]))

