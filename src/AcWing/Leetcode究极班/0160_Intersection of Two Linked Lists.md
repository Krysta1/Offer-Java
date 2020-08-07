#### 问题描述
Write a program to find the node at which the intersection of two singly linked lists begins.

#### 解题思路
老题了，两个指针分别从表头开始向后走。

如果某一个走到头的话，就从另一个的头结点开始走。

这样一定能够保证通过 len(linkA) + len(linkB) 步骤移动两个指针同时走到 链表的结尾。

但是如果两个链表有相交部分的话，也一定会相遇。

linkA 的长度 + linkB相交前的长度 = linkB 的长度 + linkA相交前的长度

#### 代码

    # Definition for singly-linked list.
    # class ListNode:
    #     def __init__(self, x):
    #         self.val = x
    #         self.next = None
    
    class Solution:
        def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
            dummyA = headA
            dummyB = headB
            if headA == None or headB == None:
                return None
            
            while headA or headB:
                if headA == headB:
                    return headA
                else:
                    if headA == None:
                        headA = dummyB
                        continue
                    if headB == None:
                        headB = dummyA
                        continue
                        
                    headA = headA.next
                    headB = headB.next
                    
            return None
                        
                    

#### 总结