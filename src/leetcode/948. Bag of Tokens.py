class Solution(object):
    def bagOfTokensScore(self, tokens, P):
        """
        :type tokens: List[int]
        :type P: int
        :rtype: int
        """
        tokens = sorted(tokens)

        if len(tokens) == 0 or tokens[0] > P:
            return 0

        l, r = 0, len(tokens) - 1
        res = 0

        while l <= r and l < len(tokens) and r >= 0:
            while l < len(tokens) and r >= 0 and tokens[l] <= P and l <= r:
                P -= tokens[l]
                res += 1
                l += 1

            if l >= r - 1:
                break
            else:
                P += tokens[r]
                res -= 1
                r -= 1

        return res


s = Solution()
print(s.bagOfTokensScore([100, 200, 300, 400], 200))
