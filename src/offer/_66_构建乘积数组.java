/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 解题思路：
 * 1.最初的想法就是直接求出所有的乘积，再新建一个数组，每个元素等于 total / a[i]
 *   但是有一个问题就是 如果一旦出现0就会报错，对出现0的情况进行特殊处理。
 *   统计出现0的次数，出现大于两次，所有元素都是0
 *   如果出现一次，那么就只有出现0的位置上，值为total，其他的为0；
 * 2.很巧妙的对称遍历：
 *   从左往右遍历累乘，结果保存在数组 res 中，此时 res[i] 表示，A[i]左边所有元素的乘积
 *   然后从右往左遍历累乘，获取A[i] 右边所有元素的乘积
 *   两边遍历之后得到的 res，就是最终结果
 */

class Solution {
    public int[] constructArr(int[] a) {
        int total = 1;
        int l = a.length;
        int[] res = new int[l];
        int zeroCount = 0;
        for (int i = 0; i < l; i ++){
            if (a[i] == 0){
                zeroCount ++;
                continue;
            }
            total *= a[i];
        }
        if (zeroCount > 1) {
            return res;
        }
        else if (zeroCount == 1){
            for (int i = 0; i < l; i ++){
                if (a[i] == 0){
                    res[i] = total;
                    return res;
                }
            }
        }
        else{
            for (int i = 0; i < l; i ++){
                res[i] = total / a[i];
            }
            return res;
        }
        return res;
    }
}

class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] result = new int[len];
        // 将所有初始化为 1
        for (int i = 0; i < len; i++) {
            result[i] = 1;
        }
        int left = 1;
        for (int i = 0; i < len; i++) {
            result[i] = left;
            left = a[i] * left;  // 给left一个个乘上去
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;  // 因为假设是在最后，那最右边的初始确实是1
            right *= a[i];  // 给right一个个乘上去
        }
        return  result;
    }
}

