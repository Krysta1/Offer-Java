/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 解题思路：用两个栈，stack1和stack2
 *          stack2用于输出，输出时如果stack2的size为0的话，返回-1.
 *          输入时，stack2一次出栈，加到stack1里，加入元素，再一次加回stack2。
 */
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while( !stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(value);
        while( !stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int deleteHead() {
        if (stack2.size() == 0){
            return -1;
        }
        else{
            return stack2.pop();
        }
    }
}