/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 解题思路：
 * 1.二分搜索：
 *   如果nums[mid] == mid 去左面找
 *   如果nums[mid] != mid 去右面找
 *   找到第一个nums[mid] != mid 的位置。最后返回left
 */
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 0) return 0;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] != mid){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}