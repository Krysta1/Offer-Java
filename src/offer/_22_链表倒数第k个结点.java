package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 给定一个链表: 1->2->3->4->5, 和 k = 2. 返回链表 4->5
 *
 * 基本思路：用两个指针初始化为头结点，一起向后移动，第一个先向后移动k个
 *          然后两个同时向后移动，直到第一个结点到链表的结尾，那么后面的结点就是出于倒数第k个结点前一个。
 *          对结点进行操作，返回结果。
 *
 * 注意代码的鲁棒性：1. head是null
 *                 2. k的值大于链表长度时
 *                 3. 输入的k为0
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) return null; // 处理注意情况 1， 3

        ListNode first = head, second = head;
        for (int i = 0; i < k; i ++){  // first先向后移动k个位置
            if (first == null) return null;
            first = first.next;
        }
        if (first == null) return head;  // 特殊判断k等于链表长度的时候，直接返回头结点即可

        while (first.next != null){  // first和second一起向后直到first到链表结尾
            first = first.next;
            second = second.next;
        }

        ListNode res = second.next; // 标记倒数第k个结点
        second.next = null;  // 将倒数k+1个结点与后面的链表断开

        return res;
    }
}