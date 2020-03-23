/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 解题思路：
 * 1.两次循环，一次统计次数，下一次遍历到中间位置返回。
 * 2.快慢双指针，一个走一步，一个走两步。最后fast到结尾，slow就会到达中间位置。
 */

// 两次循环
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            count ++;
            tmp = tmp.next;
        }
        count = count / 2;
        // System.out.println(c);
        while(count != 0){
            count --;
            head = head.next;
        }
        return head;
    }
}

// 快慢指针
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}