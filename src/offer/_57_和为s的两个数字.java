/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 解题思路：
 * 1.双指针：left = 0 right = length - 1
 *   < target left ++
 *   > target right --
 *   == target 返回这两个值，最后没有结果返回空的数组即可。
 * 2.HashSet 查看target - num是否保存在HashSet中
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        int a, b;
        int left = 0, right = l - 1;
        while (left < right){
            int tmp = nums[left] + nums[right];
            if (tmp == target) return new int[]{nums[left], nums[right]};
            if (tmp > target) right --;
            if (tmp < target) left ++;
        }
        return new int[0];
    }
}

