/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 解题思路：
 * 1.HashMap，使用HashMap统计元素出现次数，如果出现次数大于n/2，直接返回就行。
 * 2.数组排序，排序之后，众数一定在中间。
 * 3.摩尔投票法：题解看到的，这叫法还挺洋气
 *   想法就是，对一个数组进行投票，如果是众数，+1，否则-1。最后投票结果的总和一定是>0的
 *   统计vote次数，vote变为零的时候，将当前的数置为候选的众数。
 *   遇到相同的数vote++，否则vote--
 *   双100很快。
 */

// HashMap
class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        int res = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num: nums){
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            if (hashmap.get(num) > l / 2){
                res = num;
                break;
            }
        }
        return res;
    }
}

// 摩尔投票法
class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int res = 0;
        for (int num: nums){
            if (vote == 0){
                res = num;
                vote ++;
                continue;
            }
            if (num == res){
                vote ++;
            }
            else{
                vote --;
            }
        }
        return res;
    }
}