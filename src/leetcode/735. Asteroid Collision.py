class Solution(object):
    def asteroidCollision(self, asteroids):
        res = []
        for asteroid in asteroids:
            while len(res) and asteroid < 0 and res[-1] > 0:
                if res[-1] == -asteroid:
                    res.pop()
                    break
                elif res[-1] < -asteroid:
                    res.pop()
                    continue
                else:
                    break
            else:
                res.append(asteroid)
        return res


s = Solution()
print(s.asteroidCollision([5,10,-5]))
