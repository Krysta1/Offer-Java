/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 解题思路：用两个指针first，second来保存当前要反转的两个节点，一个指针secondNext保存考前节点的后一个节点。
 *          反转两个指针，并将两个指针同时向后移动。直到前面的指针到达链表结尾。
 *          返回first指针即可。
 *
 *          也可以使用递归方法求解：
 *          递归终止条件：head 或者head.next == null，用一个变量保存最后一个节点，返回。
 *          递归过程：将head.next.next = head
 *                   head.next = null
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode save_head = head; // 可以直接从null和head开始，省去头结点的判断
        ListNode first = head, second = head.next;

        while (second != null){
            ListNode secondNext = second.next;
            second.next = first;
            first = second;
            second = secondNext;
        }
        save_head.next = null;
        return first;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}