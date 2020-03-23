/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 解题思路：
 * 1.第一眼看上去好像可以理解成给定一个入栈顺序，然后返回所有的出栈顺序的序列。正好昨天研究过。试一下。
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