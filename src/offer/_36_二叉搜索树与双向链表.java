/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 解题思路：
 * 1.在中序遍历中，保存前一个节点pre
 *   在遍历左子树和右子树之间，把pre和root两个节点连接起来，同时pre = root
 *   最后返回pre（其实也就是root），最终返回的是中序遍历的最后一个节点，最大值。也就是双向链表的tail
 *   最后链接head和tail
 *   （其实底下的代码inOrder(Node node)更好理解一点。
 *   tail == null 其实就是初始化，这次head = root，相当于初始化head
 *   然后不断跟踪tail节点。
 *   最后链接head 和 tail即可。
 */

/*
// Definition for a Node.
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
    Node head, tail;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrder(root);
        // Node dummy = new Node(0);
        // Node tail = inOrder(root, dummy);
        // Node head = dummy.right;

        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (tail == null){
            head = root;
        }
        else{
            tail.right = root;
            root.left = tail;
        }
        // pre = root;
        tail = root;
        inOrder(root.right);
    }
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