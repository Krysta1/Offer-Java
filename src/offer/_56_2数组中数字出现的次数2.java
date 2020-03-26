/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 解题思路：
 * 1.暴力解法：就使用HashMap保存出现次数。
 * 2.位运算：
 *   对所有的位数进行循环，对于int是32次。
 *   对于每一位，对整个列表进行循环，如果最后出现1的次数不是3的倍数，
 *   就证明数组中唯一出现一次的那个数字在次位置一定为1。
 *   每次对结果进行或操作即可。
 * 3.还有状态机的做法。有点秀。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i ++){
            int cnt = 0;
            int bit = 1 << i;
            for (int num: nums){
                if ((num & bit) != 0) cnt ++;
            }
            if (cnt % 3 != 0){
                res |= bit;
            }
        }
        return res;
    }
}