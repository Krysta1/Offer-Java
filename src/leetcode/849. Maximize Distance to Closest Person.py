class Solution(object):
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        pre = -1
        res = 0
        for i, seat in enumerate(seats):
            if seat == 1:
                if pre == -1:
                    res = max(res, i)
                else:
                    res = max(res, (i - pre) // 2)
                pre = i
        if seats[-1] == 0:
            res = max(res, (len(seats) - 1) - pre)
        return res

    def maxDistToClosest2(self, seats):
        res, last, n = 0, -1, len(seats)
        for i in range(n):
            if seats[i]:
                res = max(res, i if last < 0 else (i - last) / 2)
                last = i
        return max(res, n - last - 1)
