class Solution(object):
    def combinationSum(self, candidates, target):
        res = []
        def dfs(candidates, target, r):
            for candidate in candidates:
                if candidate == target:
                    r.append(candidate)
                    tmp = sorted(r)
                    if tmp not in res:
                        res.append(tmp)
                    r.pop()
                elif candidate < target:
                    r.append(candidate)
                    target -= candidate
                    dfs(candidates, target, r)
                    target += candidate
                    r.pop()
                else:
                    continue
        dfs(candidates, target, [])
        return res


    def combinationSum1(self, candidates, target):
        res = []
        def dfs(candidates, target, r):
            if target == 0:
                res.append(r)
                # return
            for i in range(len(candidates)):
                if candidates[i] > target:
                    continue
                dfs(candidates[i:], target - candidates[i], r + [candidates[i]])

        dfs(candidates, target, [])
        return res


s = Solution()
print(s.combinationSum([7,12,5,10,9,4,6,8], 32))
print(s.combinationSum1([7,12,5,10,9,4,6,8], 32))
