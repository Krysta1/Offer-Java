#### 问题描述
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

Example 1:

    Input: version1 = "0.1", version2 = "1.1"
    Output: -1
Example 2:
    
    Input: version1 = "1.0.1", version2 = "1"
    Output: 1
Example 3:

    Input: version1 = "7.5.2.4", version2 = "7.5.3"
    Output: -1
Example 4:

    Input: version1 = "1.01", version2 = "1.001"
    Output: 0
    Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:

    Input: version1 = "1.0", version2 = "1.0.0"
    Output: 0
    Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"

#### 解题思路
split 分割成列表，进行比较即可。

不过要注意：

    "7.5.3"
    "7.5.3.0"
    
如果其中一个到结尾，两个都相同，并且另一个较长的后面都是 0 的时候，要记得返回 0

#### 代码

    class Solution:
        def compareVersion(self, version1: str, version2: str) -> int:
            one = version1.split('.')
            # print(one)
            two = version2.split('.')
            
            index = min(len(one), len(two))
            for i in range(index):
                if int(one[i]) > int(two[i]):
                    return 1
                elif int(one[i]) < int(two[i]):
                    return -1
                
            # if (one[index-1] == two[index-1]):
            if len(one) == len(two):
                return 0
    
            if (len(one) > len(two)):
                while index <= len(one) - 1 and int(one[index]) == 0: index += 1
                if index == len(one):
                    return 0
                else:
                    return 1
    
            if (len(one) < len(two)):
                while index <= len(two) - 1 and int(two[index]) == 0: index += 1
                if index == len(two):
                    return 0
                else:
                    return -1
                
            return 0
    
    
    def compareVersion(self, version1, version2):
            versions1 = [int(v) for v in version1.split(".")]
            versions2 = [int(v) for v in version2.split(".")]
            for i in range(max(len(versions1),len(versions2))):
                v1 = versions1[i] if i < len(versions1) else 0
                v2 = versions2[i] if i < len(versions2) else 0
                if v1 > v2:
                    return 1
                elif v1 < v2:
                    return -1;
            return 0;                
                
    class Solution {
    public:
        int compareVersion(string version1, string version2) {
            int p1 = 0, p2 = 0;
            int num1 = 0, num2 = 0;
            while(p1 < version1.size() || p2 < version2.size()){
                while(p1<version1.size()&&version1[p1]!='.'){//解析两个小数点之间的数字
                    num1 = num1*10+version1[p1]-'0';
                    p1++;
                }
                while(p2<version2.size()&&version2[p2]!='.'){
                    num2 = num2*10 + version2[p2] - '0';
                    p2++;
                }
                if(num1>num2)
                    return 1;
                if(num1<num2)
                    return -1;
                num1 = 0;//注意这里要置0
                num2 = 0;
                p1++;
                p2++;
            }
            return 0;
        }
    };
    
    作者：cornerCao
    链接：https://www.acwing.com/solution/content/80/
    来源：AcWing
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
#### 总结
写出来了，但是不是很简洁。看了discuss的，我傻了，太简洁了吧

看了一个题解，解析字符串的思路，还不错。