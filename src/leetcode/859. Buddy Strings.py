class Solution(object):
    def buddyStrings(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if len(A) != len(B):
            return False

        count = 0
        index = []
        for i in range(len(A)):
            if A[i] != B[i]:
                count += 1
                index.append(i)
            if count > 2:
                return False

        if count == 0:
            for c in A:
                if A.count(c) >= 2:
                    return True
            return False

        if count == 1:
            return False

        l, r = index[0], index[1]
        if A[l] == B[r] and A[r] == B[l]:
            return True
        else:
            return False

