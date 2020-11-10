class Solution(object):
    def maxAncestorDiff(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def dfs(root, mi, ma):
            if not root:
                return ma - mi

            ma = max(ma, root.val)
            mi = min(mi, root.val)
            return max(dfs(root.left, mi, ma), dfs(root.right, mi, ma))

        if not root: return 0
        return dfs(root, root.val, root.val)