# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def insertIntoBST(self, root, val):
        if root == None:
            return TreeNode(val)
        dummy = root
        tmp = root
        while root:
            tmp = root
            if root.val < val:
                root = root.right
            elif root.val > val:
                root = root.left
        # print(tmp.val)
        newTreeNode = TreeNode(val)
        if tmp.val > val:
            tmp.left = newTreeNode
        else:
            tmp.right = newTreeNode

        return dummy
