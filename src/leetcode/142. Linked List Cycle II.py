# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        #         if not head:
        #             return None

        #         root = head
        #         save = []
        #         while root:
        #             if root in save:
        #                 return root
        #             else:
        #                 save.append(root)
        #             root = root.next
        #         return None
        if not head:
            return None

        first = head
        second = head

        while second and second.next:
            first = first.next
            second = second.next.next
            if first == second:
                break
        else:
            return None

        first = head
        while first != second:
            first = first.next
            second = second.next
        return first