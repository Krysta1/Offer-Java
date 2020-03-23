/**
 *
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // Node pre, head, tail;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        // inOrder(root);
        Node dummy = new Node(0);
        Node tail = inOrder(root, dummy);
        Node head = dummy.right;

        head.left = tail;
        tail.right = head;
        return head;
    }

    // public void inOrder(Node root){
    //     if (root == null){
    //         return;
    //     }
    //     inOrder(root.left);
    //     root.left = pre;
    //     if (pre == null){
    //         head = root;
    //     }
    //     else{
    //         pre.right = root;
    //     }
    //     pre = root;
    //     tail = root;
    //     inOrder(root.right);
    // }
    public Node inOrder(Node root, Node pre){
        if (root == null){
            return pre;
        }
        pre = inOrder(root.left, pre);
        pre.right = root;
        root.left = pre;
        pre = root;
        pre = inOrder(root.right, pre);
        return pre;
    }
}