/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 解题思路：
 * 1.bfs：
 * serialize：和普通层次遍历不同的是，当发现左右孩子为空的时候，要记得在结果字符串中添加null节点
 * deserialize：就是进行一个逆向操作。当前节点的左孩子或者右孩子读取到null的时候，要记得指向null节点。
 *              其他情况记得使用数组中的值初始化新的节点，并将当前节点的left right指向它即可。最后返回root
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
public class Codec {
    private String res;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res = "[" + root.val;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                res += "," + node.left.val;
            }
            else{
                res += ",null";
            }
            if(node.right != null){
                queue.offer(node.right);
                res += "," + node.right.val;
            }
            else{
                res += ",null";
            }
        }
        res += "]";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2){
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
        queue.offer(root);
        index ++;
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if (nodes[index].equals("null")){
                tmp.left = null;
            }
            else{
                tmp.left = new TreeNode(Integer.valueOf(nodes[index]));
                queue.offer(tmp.left);
            }
            index ++;
            if (nodes[index].equals("null")){
                tmp.right = null;
            }
            else{
                tmp.right = new TreeNode(Integer.valueOf(nodes[index]));
                queue.offer(tmp.right);
            }
            index ++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));