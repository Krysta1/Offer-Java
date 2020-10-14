# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def merge(head1, head2):
    head = ListNode(-1)
    cur = head
    while head1 and head2:
        if head1.val < head2.val:
            cur.next = head1
            head1 = head1.next
        else:
            cur.next = head2
            head2 = head2.next
        cur = cur.next
    if head1 is None:
        cur.next = head2
    else:
        cur.next = head1
    return head.next


class Solution(object):
    def sortList(self, head):
        if head is None or head.next is None:
            return head
        pre = None
        head1 = head
        head2 = head
        while head2 and head2.next:
            pre = head1
            head1 = head1.next
            head2 = head2.next.next
        pre.next = None
        l1 = self.sortList(head)
        l2 = self.sortList(head1)
        return merge(l1, l2)


head1 = ListNode(4)
head1.next = ListNode(2)
head1.next.next = ListNode(1)
head1.next.next.next = ListNode(3)
head1.next.next.next.next = None
#
# head2 = ListNode(1)
# head2.next = ListNode(3)
# head2.next.next = None
#
# head = merge_sort(head1, head2)
#
# while head:
#     print(head.val)
#     head = head.next

s = Solution()


head = s.sortList(head1)
while head:
    print(head.val)
    head = head.next
