class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        last_index = {}
        for index, ch in enumerate(s):
            last_index[ch] = index 
        cur_result = ''
        for i, ch in enumerate(s):
            if ch not in cur_result:
                while ch < cur_result[-1:] and i < last_index[cur_result[-1]]:
                    cur_result = cur_result[:-1]
                cur_result += ch
        return cur_result
