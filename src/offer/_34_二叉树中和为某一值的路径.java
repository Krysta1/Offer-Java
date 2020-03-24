/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 其中sum = 22的路径有：5-4-11-2  5-8-4-5
 * 解题思路：
 * 1.dfs：在左右子树中去搜索sum - root.val的解。
 *   递归的出口：node == full return
 *   当递归到叶子节点时，要去判断sum == 0，如果等于零就要把这个答案添加到答案中，（这里要记得添加的是一份copy。就这里卡了好久。。）
 *   然后在遍历完左右子树之后要记得，恢复状态。
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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        List<Integer> result = new ArrayList<>();
        helper(root, sum, result);
        return res;
    }

    public void helper(TreeNode node, int sum, List<Integer> result){
        if (node == null) return;
        result.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0){
            // 一直卡在这，不要忘记拷贝一份。
            res.add(new ArrayList<>(result));
        }
        helper(node.left, sum, result);
        helper(node.right, sum, result);
        result.remove(result.size() - 1);
    }
}