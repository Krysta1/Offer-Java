#### 问题描述
Given an input string, reverse the string word by word.

    Example 1:
    
    Input: "the sky is blue"
    Output: "blue is sky the"
    Example 2:
    
    Input: "  hello world!  "
    Output: "world! hello"

Explanation: Your reversed string should not contain leading or trailing spaces.

#### 解题思路
1. using the build-in function strip and split

2. firstly, reverse each word in the string. 
   secondly, reverse the whole string

#### 代码

    class Solution:
        def reverseWords(self, s: str) -> str:
            word_list = s.strip().split()
            return ' '.join(reversed(word_list))
            
            
    class Solution:
        def reverseWords(self, s: str) -> str:
            res = []
            word = ''
            
            for i in range(len(s)):
                if s[i] != ' ':
                    word += s[i]
                else:
                    if word:
                        res.append(word)
                        word = ''
                    
                if i == len(s) - 1 and word:
                    res.append(word)

            return ' '.join(reversed(res))

#### 总结

- 总结python字符串处理的函数 strip  split  
https://blog.csdn.net/donahue_ldz/article/details/12783249

- reversed(list) 将一个list 反转

- 字符串可以直接使用 s[::-1] 的形式进行翻转，然后可以通过 s[:i] + s[i:j][::-1] + s[:j] 对i，j中间的部分进行翻转。