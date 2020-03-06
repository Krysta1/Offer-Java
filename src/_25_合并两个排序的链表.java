/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 解题思路：
 * 1. 迭代方法：新建一个为头结点，然后依次比较每个链表的头结点，将较小的值链接到新建头结点后方，
 *             直到其中一个链表走到结尾，最后将另一个链表中剩下的结点链接上即可。
 *
 * 2. 递归方法：递归出口：其中一个链表为空，则返回另一个链表。（也就是迭代方法中，一个走到结尾的情况）
 *             递归过程：让较小结点的next等于下次迭代返回的结果，并返回较小的结点。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode l3 = new ListNode(-1);
         ListNode head = l3;
         while (l1 != null && l2 != null){
             if (l1.val <= l2.val){
                 head.next = l1;
                 l1 = l1.next;
                 head = head.next;
             }
             else{
                 head.next = l2;
                 l2 = l2.next;
                 head = head.next;
             }
         }
         if (l1 == null) head.next = l2;
         else head.next = l1;

         return l3.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode tmp = new ListNode(-1);
        if (l1.val <= l2.val){
            tmp = l1;
            tmp.next = mergeTwoLists(l1.next, l2);
        }
        else{
            tmp = l2;
            tmp.next = mergeTwoLists(l1, l2.next);
        }
        return tmp;
    }
}