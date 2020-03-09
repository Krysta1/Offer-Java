package offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 解题思路：从根节点开始，在左右子树中递归，
 *          如果left.val == right.val
 *          继续比较left.left和right.right  还有left.right和right.left
 *
 * 注意：仔细考虑下状态的分类，能节省不少代码。
 *      注释我自己写的，没注释的是别人写的。
 *      虽然都能AC，差距实在是有点大。
 *      现在的问题是：对于递归入口，总是想着特殊处理，大多时候其实是不用的，能够包含在递归过程中。
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // if (root == null || root.left == null && root.right == null) return true;
        // if (root.left != null && root.right != null && root.left.val == root.right.val){
        //     return dfs(root.left, root.right);
        // }
        // return false;
        if (root == null) return true;
        else return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right){
        // if (left == null && right != null || left != null && right == null)return false;
        // if (left == null && right == null) return true;
        // boolean res = false;
        // if (left.val == right.val){
        //     res = dfs(left.right, right.left) && dfs(left.left, right.right);
        // }
        // return res;
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
