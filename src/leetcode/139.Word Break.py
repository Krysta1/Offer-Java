class Solution(object):
    def wordBreak(self, s, wordDict):
        self.flag = False
        def help(s, wordDict):
            for word in wordDict:
                if s == "":
                    return
                if s == word:
                    self.flag = True
                    return
                if s.startswith(word):
                    left = len(word)
                    help(s[left:], wordDict)
                    return
        help(s, wordDict)
        return self.flag


s = Solution()
str = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb"
word = ["abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"]
print(s.wordBreak(str, word))
