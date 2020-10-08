# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head:
            return None

        tail = head
        length = 1
        while tail.next:
            tail = tail.next
            length += 1
        # print(length)
        k = k % length
        if k == 0:
            return head

        tail.next = head
        newTail = head
        for i in range(length - k - 1):
            newTail = newTail.next
        # print(newTail.val)
        newHead = newTail.next
        newTail.next = None

        return newHead


head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)
head.next.next.next.next.next = None

s = Solution()
newHead = s.rotateRight(head, 13)

while newHead:
    print(newHead.val)
    newHead = newHead.next
