/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 解题思路：
 * 1.和上一个思路类似，但是在弹出queue的时候，要一次弹出当前队列大小个元素（其实也就是一层的元素）
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> inList = new ArrayList<>();
            for(int i = queue.size(); i > 0; i --){
                TreeNode node = queue.poll();
                inList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(inList);
        }
        return list;
    }
}