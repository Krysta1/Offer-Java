#### 问题描述
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, just return any of them.

Example 1:

    Input: numerator = 1, denominator = 2
    Output: "0.5"
Example 2:
    
    Input: numerator = 2, denominator = 1
    Output: "2"
Example 3:

    Input: numerator = 2, denominator = 3
    Output: "0.(6)"

#### 解题思路
首先判断正负，还有整除的情况。

对于小数的情况，不断地循环计算，同时将结果和长度保存到一个 dic 里面，当下次再出现这个数的时候，就以为着发生了循环，通过保存的长度来调整输出结果，以满足题目的输出要求。

#### 代码

    class Solution:
        def fractionToDecimal(self, numerator: int, denominator: int) -> str:
            res = ''
            if numerator / denominator < 0: res += "-"
                
            if numerator % denominator == 0: return str(int(numerator / denominator))
            
            numerator = abs(numerator)
            denominator = abs(denominator)
            
            res += str(int(numerator / denominator))
            res += "."
            
            numerator = numerator % denominator
            length = len(res)
            dic = {}
            
            while numerator != 0:
                if numerator not in dic.keys():
                    dic[numerator] = length
                else:
                    i = dic[numerator]
                    res = res[:i] + "(" + res[i:] + ")"
                    return res
                
                numerator *= 10
                res += str(int(numerator / denominator))
                numerator %= denominator
                length += 1
                
            return res
            

#### 总结
分数是不会出现无限不循环小数的，注意一下哈...小学数学都忘了

str() 将数字转化成字符串