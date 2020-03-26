/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 * 解题思路：
 * 1.暴力搜索：
 *   遍历整个数组，对一个元素，如果之后有一个预算比它小，count++。超时了，数组大小50000，时间复杂度n^2 不行。
 * 2.结合归并排序解法：
 *   对于7，5，6，4
 *   将其分成两个部分  7 5 和 6 4
 *   分别在各个部分中统计逆序对的个数，并将两部分进行合并同时统计两部分中出现逆序对的个数。
 */

class Solution {
    public int reversePairs(int[] nums) {
        int l = nums.length;
        if (l <= 1) return 0;
        // int count = 0;
        // for (int i = 0; i < l; i ++){
        //     for (int j = i + 1; j < l; j ++){
        //         if (nums[j] < nums[i]){
        //             count ++;
        //         }
        //     }
        // }
        // return count;
        int[] tmp = new int[l];
        return helper(nums, 0, l - 1, tmp);
    }
}
// 归并排序
class Solution {
    public int reversePairs(int[] nums) {
        int l = nums.length;
        if (l <= 1) return 0;
        int[] tmp = new int[l];
        return helper(nums, 0, l - 1, tmp);
    }

    public int helper(int[] nums, int left, int right, int[] tmp){
        if (right == left){
            return 0;
        }
        int mid = (left + right) >>> 1;
        int leftPair = helper(nums, left, mid, tmp);
        int rightPair = helper(nums, mid + 1, right, tmp);

        if (nums[mid] < nums[mid + 1]){
            return leftPair + rightPair;
        }

        int mergePair = merge(nums, left, mid, right, tmp);
        return leftPair + rightPair + mergePair;
    }

    public int merge(int[] nums, int left, int mid, int right, int[] tmp){
        int res = 0;
        for (int i = left; i <= right; i ++){
            tmp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k ++){
            if (i > mid){
                nums[k] = tmp[j];
                j ++;
            }
            else if (j > right){
                nums[k] = tmp[i];
                i ++;
            }
            else if (tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i ++;
            }
            else{
                nums[k] = tmp[j];
                j ++;
                res += (mid - i + 1);
            }
        }
        return res;
    }
}