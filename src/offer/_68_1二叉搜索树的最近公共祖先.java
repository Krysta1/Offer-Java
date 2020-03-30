/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 解题思路：
 * 1.LCA问题：
 *   一共有三种情况，
 *   pq分别在root节点的左右子树中，那么root就是LCA
 *   pq同在左子树，去左子树中递归
 *   pq同在右子树，去右子树中递归
 *   可以根据二叉搜索树的性质确定pq是否在左右子树中。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > rootVal && qVal > rootVal){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (pVal < rootVal && qVal < rootVal){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
    }
}