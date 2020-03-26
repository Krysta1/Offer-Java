/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 解题思路：
 * 1.双指针相遇：
 *   一个指针从headA开始，到最后将指针置为headB
 *   另一个从headB开始，遍历到最后置为headA
 *   两个指针相遇时，即是两个链表相交节点。
 *   原理：
 *   比如多于  4-1-8-4-5  和 5-0-1-8-4-5
 *   重复的长度为3（8-4-5）  4-1长度为2   5-0-1长度为3
 *   最后两个指针相遇时，走的距离分别是  2-3-3  和 3-3-2 正好在8的位置相遇。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
//            if (A == null){
//                A = headB;
//            }
//            else{
//                A = A.next;
//            }
//            if (B == null){
//                B = headA;
//            }
//            else{
//                B = B.next;
//            }
        }
        return A;
    }
}