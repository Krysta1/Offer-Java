class Solution(object):
    def bitwiseComplement(self, N):
        """
        :type N: int
        :rtype: int
        """
        # num_bin = bin(N).replace('0b', '')
        # # print(num_bin)
        # num_complement = [str(abs(int(x) - 1)) for x in num_bin]
        # res = "".join(num_complement)
        # return int(res, 2)

        # more brilliant way
        X = 1
        while N > X: X = X * 2 + 1
        return X - N


s = Solution()
print(s.bitwiseComplement(12345))
