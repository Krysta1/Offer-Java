class Solution(object):
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        # if len(A) == 0 or len(A[0]) == 0:
        #     return []
        # row = len(A)
        # for i in range(row):
        #     A[i] = [abs(x - 1) for x in A[i][::-1]]
        # return A

        # or in this way
        return [[1 - x for x in B[::-1]] for B in A]