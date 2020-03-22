/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。（其实就是层次遍历）
 * 解题思路：
 * 1.使用队列层级遍历即可。BFS
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            list.add(node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}