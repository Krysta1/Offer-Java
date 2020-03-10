/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 解题思路：遍历整个链表，使用一个栈保存，再一次弹出保存到数组里即可。
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (head != null){
            stack.add(head.val);
            count ++;
            head = head.next;
        }
        int[] res = new int[count];
        for (int i = 0; i < count;i ++){
            res[i] = stack.pop();
        }
        return res;
    }
}
