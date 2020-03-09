package offer;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 解题思路：遍历树A，找到val和B的根节点值相等的值，从这个节点开始递归判断是否有一个子树可以和B相同。
 *          在递归判断中，如果A为null，返回false。如果B为null，返回true。
 *          如果A，B的val相同就要继续看左右子树是否一样。否则就返回false。
 * 注意：在进行取值操作前要记得判断节点是否为null，否则会出现空指针异常。
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if (A != null && B != null){
            if (A.val == B.val) res = helper(A, B);
            if (!res) res = isSubStructure(A.left, B);
            if (!res) res = isSubStructure(A.right, B);
        }
        return res;
    }

    public boolean helper(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val != B.val) return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
