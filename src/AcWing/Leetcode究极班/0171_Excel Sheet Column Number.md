#### 问题描述

#### 解题思路

#### 代码
    
    class Solution:
        def titleToNumber(self, s: str) -> int:
            res = 0
            l = len(s) - 1
            for char in s:
                res += (ord(char) - ord('A') + 1) * 26 ** l
                l -= 1
                
            return res

#### 总结