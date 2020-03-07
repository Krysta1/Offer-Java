/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 解题思路：从根结点开始递归反转左右子树。
 *          如果node为null或者 node的左右结点都为空 直接返回
 *          对左右子树进行交换。左子树不空，递归调用左子树。右子树不空，递归调用右子树。
 *          最后返回root即可。
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if (node == null) return;
        if (node.left == null && node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
    }
}