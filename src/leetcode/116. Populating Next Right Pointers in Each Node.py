# My solution
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None

        stack = []
        stack.append(root)
        root.next = None

        while stack:
            total = len(stack)

            for i in range(total):
                pre = stack.pop(0)
                if i != total - 1:
                    pre.next = stack[0]
                else:
                    pre.next = None
                if pre.left:
                    stack.append(pre.left)
                if pre.right:
                    stack.append(pre.right)

        return root

# Discussion
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        cur = root  # current node of current level
        head = Node(0)  # head of the next level
        pre = head  # the current node on the next level

        while cur:
            # if cur has left node, connect pre and cur.left, move cur forward
            if cur.left:
                pre.next = cur.left
                pre = pre.next
            # if cur has right node, connect pre and cur.right, move cur forward
            if cur.right:
                pre.next = cur.right
                pre = pre.next
            # if cur has next, move cur to the next
            if cur.next:
                cur = cur.next
            # if not, cur = next level's head node, disconnect the head the the first node in the next level
            # so as pre
            else:
                cur = head.next
                head.next = None
                pre = head

        return root
