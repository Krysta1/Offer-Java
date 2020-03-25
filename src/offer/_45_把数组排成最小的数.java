/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 解题思路：
 * 1.拼接数组中的所有数字，组成一个数使之最小。也就是将数组按照一定的规则排列好之后，一次拼接即可。
 *   自定义排列原则：
 *   如果str1 + str2 比 str2 + str1 组成字符串的数字更大，那么str1 > str2
 *   这里注意要使用数组进行比较，否则可能会出现整数溢出现象。
 *   然后再自定义一个冒泡排序（因为简单），将数组按照自定义规则排序好。
 *   依次拼接，输出结果即可。
 * 2.使用Arrays.sort  然后自定义比较函数。
 *   (s1,s2)->(s1+s2).compareTo(s2+s1)注意compareTo返回值是int
 */
// 自定义排序方法加冒泡排序
class Solution {
    public String minNumber(int[] nums) {
        int[] numsTmp = sort(nums);
        String res = "";
        for (int num: numsTmp){
            res += String.valueOf(num);
        }
        return res;
    }

    public int[] sort (int[] nums){
        for (int i = 0; i < nums.length; i ++){
            for (int j = 0; j < nums.length - i - 1; j ++){
                if (max(nums[j], nums[j + 1])){
                    // System.out.println(nums[j] + "dayu" + nums[j + 1]);
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    public boolean max(int a, int b){
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        char[] m = (strA + strB).toCharArray();
        char[] n = (strB + strA).toCharArray();
        int i = 0;
        while (i < m.length){
            if (m[i] > n[i]){
                return true;
            }
            else if (m[i] < n[i]){
                return false;
            }
            i ++;
        }
        return true;
    }
}

// 使用Arrays.sort
class Solution {
    public String minNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return "";
        }
        int n=nums.length;
        String [] numStr=new String [n];;
        for(int i=0;i<n;i++){
            numStr[i]=nums[i]+"";
        }
        Arrays.sort(numStr,(s1,s2)->(s1+s2).compareTo(s2+s1));
        String ret="";
        for(String str:numStr){
            ret+=str;
        }
        return ret;
    }
}