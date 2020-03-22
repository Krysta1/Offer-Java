/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 解题思路：
 * 1.在上一个题的基础上，对奇数层数进行操作时，使用一个stack；来调换顺序即可。不过代码有点长。
 * 2.看题解人家直接使用Collections.reverse(list);我恨。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        int index = 0;
        while(!queue.isEmpty()){
            ArrayList<Integer> inList = new ArrayList<>();
            if (index % 2 == 0){
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
            }
            else{
                Stack<Integer> stack = new Stack<>();
                for(int i = queue.size(); i > 0; i --){
                    TreeNode node = queue.poll();
                    stack.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }
                }
                while(!stack.isEmpty()){
                    inList.add(stack.pop());
                }
            }
            index ++;
            list.add(inList);
        }
        return list;
    }
}
