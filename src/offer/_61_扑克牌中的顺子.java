/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 解题思路：这题要注意，大小王出现的次数是可以大于2的。
 * 1.先将数组排序，统计0出现的次数
 *   从第一个不是0的位置看是否出现重复的数据
 *   如果没有  那么就要看非零数字最大，最小值 也就是nums[4] 和 nums[index]的差值是否小于4
 *   （小于4）才有可能是顺子。
 * 2.优化一下，不进行排序，降低时间复杂度。
 *   使用一个数组记录数字出现过，如果出现过直接返回false
 *   同时保存数组中的最大最小值
 *   最后返回 max - min <= 4
 */
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for ( int i = 0; i < 5; i ++){
            if (nums[i] == 0){
                index ++;
            }
        }
        // System.out.println(index);
        for ( int i = index; i < 4; i ++){
            if (nums[i + 1] == nums[i]){
                return false;
            }
        }

        return nums[4] - nums[index] <= 4;
    }
}

class Solution {
    public boolean isStraight(int[] nums) {
        int[] set = new int[15];
        int max = 0, min = 14;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0) continue;
            if (set[nums[i]] != 0) return false;
            set[nums[i]] = 1;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return max - min <= 4;
    }
}