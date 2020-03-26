/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7  最大深度3
 * 解题思路：
 * 1.递归就完事了呗。
 *   出口：root == null return 0
 *   其他 返回左右子树中的max + 1
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}