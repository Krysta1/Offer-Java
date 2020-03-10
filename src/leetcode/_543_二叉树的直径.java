/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]
 *
 * 解题思路：观察下直径的定义：两个节点之间路径的长度的最大值，
 *          我们可以考虑通过每个根节点的路径的值，其实就是左右子树深度的值+1
 *          递归求每个节点的深度，再通过一个全局变量保存路径的最大值。
 * 注意：root为空的时候，返回零；
 *      或者可以将max初始化为1，这样可以避免特殊情况的处理。
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max - 1;
    }

    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int l_depth = dfs(node.left);
        int r_depth = dfs(node.right);
        max = Math.max(max, l_depth + r_depth + 1);
        return Math.max(l_depth, r_depth) + 1;
    }
}