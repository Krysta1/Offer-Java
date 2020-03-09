package offer;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  解题思路：1. 暴力揭发能a，但是没啥意思。
 *           2. 借鉴59_2方法，维护一个双向队列，需要注意的是队首元素和当前元素超出了窗口值要记得弹出队首元素。
 */

class Solution {
    // 我的暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
         int l = nums.length;
         if (l == 0 || k == 0 || k == 1) return nums;
         int [] res = new int[l - k + 1];
         for (int i = 0; i < l - k + 1; i ++){
             int max = Integer.MIN_VALUE;
             for (int j = i; j < k + i; j ++){
                 max = Math.max(max, nums[j]);
             }
             res[i] = max;
         }
         return res;
    }
}

class Solution {
    // 我的使用dequeue解法
    public int[] maxSlidingWindow(int[] nums, int k) {
         int l = nums.length;
         if (l == 0 || k == 0 || k == 1) return nums;
         int [] res = new int[l - k + 1];
         Deque<Integer> deque = new LinkedList<>();
         deque.offer(0);
         for (int i = 1; i < l; i ++){
             if (i - deque.peek() == k){
                 deque.poll();
             }
             while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]){
                 deque.pollLast();
             }
             deque.offerLast(i);
             if ( i > k - 2) res[i-k+1] = nums[deque.peekFirst()];
         }
         return res;
    }
}

class Solution {
    // 题解中暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0){
            return new int[0];
        }
        //定义结果数组
        int[] res = new int[len - k + 1];
        //maxInd记录每次最大值的下标，max记录最大值
        int maxInd = -1, max = Integer.MIN_VALUE;

        for (int i = 0; i < len - k + 1; i++) {
            //判断最大值下标是否在滑动窗口的范围内
            if (maxInd >= i && maxInd < i + k){
                //存在就只需要比较最后面的值是否大于上一个窗口最大值
                if (nums[i + k - 1] > max){
                    max = nums[i + k - 1];
                    //更新最大值下标
                    maxInd = i + k - 1;
                }
            }
            //如果不在就重新寻找当前窗口最大值
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}