/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点
 * 返回删除后的链表的头节点。
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 解题思路：直接使用dummy节点  dummy.next = head，然后始终用一个pre节点跟踪当前节点的前一个节点
 *          最后返回dummy.next即可
 *
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = dummy;
        while (head != null){
            if (head.val == val){
                dummy.next = head.next;
            }
            head = head.next;
            dummy = dummy.next;
        }
        return res.next;
    }
}