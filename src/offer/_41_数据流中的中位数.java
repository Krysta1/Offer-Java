/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，[2,3,4] 的中位数是 3  [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 解题思路：
 * 1.使用list，add直接添加就好，find就将list排序然后根据size的奇偶返回对应的中位数即可。
 * 2.使用大小根堆：
 *   维护一个大根堆，一个小根堆，同时要保证两个堆的大小差距不能超过1。
 *   大根堆用来保存中位数之前的所有元素，
 *   小根堆用来保存中位数之后的所有元素，
 */
class MedianFinder {
    List<Integer> nums;
    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        nums.add(num);
    }

    public double findMedian() {
        Collections.sort(nums);
        int l = nums.size();
        if (l % 2 == 0){
            return (nums.get(l / 2) + nums.get(l / 2 - 1)) / 2.0;
        }
        else{
            return nums.get(l / 2) * 1.0;
        }
    }
}

class MedianFinder {
    Queue<Integer> pq1 = new PriorityQueue<>();
    Queue<Integer> pq2 = new PriorityQueue<>((a, b)-> b - a);


    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (pq2.size() < pq1.size()){
            // 保证pq1 pq2分布在中位数两侧
            pq1.add(num);
            pq2.add(pq1.poll());
        }
        else{
            pq2.add(num);
            pq1.add(pq2.poll());
        }
    }

    public double findMedian() {
        if (pq1.size() == pq2.size()){
            if (pq1.isEmpty()){
                return Double.NaN;
            }
            else{
                return (pq1.peek() + pq2.peek()) / 2.0;
            }
        }
        else if (pq2.size() > pq1.size()){
            return pq2.peek() * 1.0;
        }
        else{
            return pq1.peek() * 1.0;
        }
    }
}