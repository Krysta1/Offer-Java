/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 解题思路：
 * 1.暴力循环：遇到i+1 比 i小的时候，直接返回numbers[i+1]即可。
 * 2.二分法：如果mid > nums[right]的话，说明寻找的值在mid的左侧，mid+1 right区域里。
 *          如果mid < nums[right]的话，说明在left，mid区域里
 *          如果mid == nums[right]，无法确定具体在左右侧，将right--。
 */
class Solution {
    public int minArray(int[] numbers) {
        // 一次循环得到结果。
        // int res = numbers[0];
        // for(int i = 0; i < numbers.length - 1; i ++){
        //     if (numbers[i + 1] < numbers[i]){
        //         res = numbers[i + 1];
        //         break;
        //     }
        // }
        // return res;
        // 二分法
        int left = 0, right = numbers.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }
            else if (numbers[mid] < numbers[right]){
                right = mid;
            }
            else{
                right --;
            }
        }
        return numbers[left];
    }
}
