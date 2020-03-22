/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4] 注：[3,1,2,4] 也是正确的答案之一。也就是不关注元素顺序。
 * 解题思路：
 * 1.双指针发现不符合规则的直接进行交换即可。
 *   l从前向后发现偶数。r从后向前发现奇数之后进行交换。知道lr相遇。
 */
class Solution {
    public int[] exchange(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int l = 0, r = length - 1;
        while (true){
            while (l < length && nums[l] % 2 == 1) l ++;
            while (r > 0 && nums[r] % 2 == 0) r --;
            if (l >= r) break;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}