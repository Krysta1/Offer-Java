/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 解题思路：
 * 1. 使用HashSet，遍历数组，如果在集合中存在，则返回。否则加入集合。
 * 2. 下标置换：对于每个元素，将其置换到nums[nums[i]] = nums[i]
 *    如果下次置换到位置相等时，出现相等的，那么就返回。
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums){
            if (!set.contains(num)) set.add(num);
            else return num;
        }
        return -1;
    }
}

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i ++){
            while (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}