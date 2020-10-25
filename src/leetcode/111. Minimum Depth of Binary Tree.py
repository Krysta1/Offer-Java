# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #         self.res = 2e16
        #         if not root:
        #             return 0

        #         self.dfs(root, 1)
        #         return self.res

        #     def dfs(self, root, depth):
        #         if not root.left and not root.right:
        #             self.res = min(depth, self.res)
        #             return
        #         if root.left:
        #             self.dfs(root.left, depth + 1)
        #         if root.right:
        #             self.dfs(root.right, depth + 1)
        #         res = 2e16

        #         if not root:
        #             return 0

        #         queue = []
        #         queue.append(root)
        #         depth = 0
        #         while queue:
        #             length = len(queue)
        #             depth += 1
        #             while length > 0:
        #                 node = queue.pop(0)
        #                 length -= 1
        #                 if not node.left and not node.right:
        #                     return depth
        #                 if node.left:
        #                     queue.append(node.left)
        #                 if node.right:
        #                     queue.append(node.right)
        #         return res
        if not root:
            return 0
        if None in [root.left, root.right]:
            return max(self.minDepth(root.left), self.minDepth(root.right)) + 1
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1



