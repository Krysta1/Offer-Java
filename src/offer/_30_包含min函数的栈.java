/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 解题思路：
 * 使用一个辅助栈，用来保存当前的最小元素，
 * push操作时，如果辅助栈空，或者x<=辅助栈顶元素，就要同时向两个栈add元素
 * pop操作时，检查pop出的元素是不是辅助栈的栈顶元素，如果是，也要pop
 * min操作，直接返回辅助栈栈顶元素即可
 * top操作，直接返回辅助栈栈顶元素即可
 */
class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
        if (stack2.size() == 0 || x <= stack2.peek()){
            stack2.add(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}