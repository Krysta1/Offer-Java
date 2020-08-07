#### 问题描述

#### 解题思路

#### 代码

    class Solution:
        def convertToTitle(self, n: int) -> str:
            alphabet = ['A', 'B', 'C', 'D', 'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y', 'Z']
            
            
            res = ''
            
            while n > 0:
                res = alphabet[(n - 1) % 26] + res
                n = (n - 1) // 26
                
            return res
            

#### 总结