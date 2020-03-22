/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 解题思路：
 * 1.使用一个辅助栈，按照pushed顺序进行入栈，如果当前栈顶的元素等于popped[index]，接着考虑下一个元素。
 *   如果最后辅助栈为空，就以为着popped是pushed的一个出栈序列。
 * 2.这里想学习一下，返回一个入栈顺序的所有出栈序列。
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index  = 0;
        int l = pushed.length;
        for (int i = 0; i < l; i ++){
            stack.push(pushed[i]);
            while(!stack.empty() && index < l && stack.peek() == popped[index]){
                index ++;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void orderList(Stack<String> stack,String result,String input){
        //利用对象克隆的方法，先把栈复制下来以免操作后影响下面
        Stack<String> temp=(Stack<String>)stack.clone();
        String subStr=input.substring(0,1);
        input=input.substring(1);
        temp.push(subStr);
        if(input.length()==0){
            while(!temp.isEmpty()){
                result += temp.pop().toString();
            }
            System.out.println(result);
        }
        else{
            orderList(temp,result,input);
            while(!temp.isEmpty()){
                result+=temp.pop();
                orderList(temp,result,input);
            }
        }
    }
}