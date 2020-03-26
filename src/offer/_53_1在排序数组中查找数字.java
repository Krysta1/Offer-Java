/**
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 解题思路：
 * 1.暴力搜索：遍历数字，比较等于target计数即可。
 * 2.二分搜索思想：mid = (left + right) >>> 1
 *   看mid 是否 = target
 *   如果等于，向左右两个方向拓展，直到遇到不等于target的位置，假设左面为i 右面为j
 *   最后结果就是j-i+1
 *
 *   题解中：二分查找k-0.5 和 k+0.5 然后 k+0.5位置 - k-0.5位置
 */
class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == target){
                count ++;
            }
        }
        return count;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else{
                int tmp1 = mid;
                while (tmp1 > 0 && nums[tmp1 - 1] == target) tmp1 --;
                int tmp2 = mid;
                while (tmp2 < nums.length - 1 && nums[tmp2 + 1] == target) tmp2 ++;
                res = tmp2 - tmp1 + 1;
                break;
            }
        }
        return res;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target + 0.5) - binarySearch(nums, target - 0.5);
    }

    private int binarySearch(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}