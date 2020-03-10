/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 解题思路：数据结构课上学过的经典题目。
 *          根据前序遍历对中序遍历进行分割，对左右两个部分分别递归建树。
 * 转自leetcode：前序遍历的第一个节点是根节点，只要找到根节点在中序遍历中的位置，在根节点之前被访问的节点都位于左子树，在根节点之后被访问的节点都位于右子树，由此可知左子树和右子树分别有多少个节点。
 *
 * 由于树中的节点数量与遍历方式无关，通过中序遍历得知左子树和右子树的节点数量之后，可以根据节点数量得到前序遍历中的左子树和右子树的分界，因此可以进一步得到左子树和右子树各自的前序遍历和中序遍历，可以通过递归的方式，重建左子树和右子树，然后重建整个二叉树。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        int l = preorder.length;
        for ( int i = 0; i < l; i ++){
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, l - 1, inorder, 0, l - 1);
        return root;
    }

    public TreeNode helper(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if (preS > preE) return null;
        int val = preorder[preS];
        TreeNode node = new TreeNode(val);
        if (preS == preE) return node;
        else{
            int nodeIndex = map.get(val);
            int leftNodes = nodeIndex - inS, rightNodes = inE - nodeIndex;
            TreeNode leftNode = helper(preorder, preS + 1, preS + leftNodes, inorder, inS, nodeIndex - 1);
            TreeNode rightNode = helper(preorder, preE -rightNodes + 1, preE, inorder, nodeIndex + 1, inE);
            node.left = leftNode;
            node.right = rightNode;
            return node;
        }
    }
}
