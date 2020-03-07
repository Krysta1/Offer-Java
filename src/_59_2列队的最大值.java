/**
 * Y请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 解题思路：使用一个队列queue记录队列，双向队列记录当前队列最大值。
 *          push_back：直接向queue中添加元素。
 *                     向dequeue中添加时，要判断队尾的元素是否小于要添加元素，如果小于要依次出队。因为value加入到queue之后
 *                     在他前面比它小的值无论如何也不能成为队列中的最大值。dequeue的队首始终保存着当前队列最大元素。
 *          max_value：直接返回dequeue的队首元素就行。
 *          pop_front：确定queue的队首元素，注意题目要求，队列为空时，返回-1、
 *                     如果不空将队首元素弹出。同时记得更新dequeue。
 *                     如果弹出元素位于dequeue队首，记得一起弹出。
 *
 * 注意：不要忘记去队列首尾元素时，判断队列的size。
 *
 */

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.size() > 0) return deque.peek();
        else return -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (deque.size() > 0 && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        int res;
        if (queue.size() > 0) res = queue.poll();
        else res = -1;

        if (deque.size()>0 && res == deque.peek()){
            deque.poll();
        }
        return res;
    }
}