/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 解题思路：
 * 1.使用HashMap记录oldNode 和 newNode 的一个映射。
 *   newNode.random = getNode(oldNode.random)
 *   next指针同理。
 *   在getNode中，如果map中存在，直接返回，不存在便初始化一个新的Node，并放入到map中即可。
 * 2.在原节点之后添加复制，变成1-1-2-2-3-3-4-4-null
 *   把复制节点的random指针更新好
 *   把复制节点从原链表中摘出来，并把原链表恢复原状。
 *   这里主要dummy节点的使用。
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node getNode(Node node){
        if (node != null){
            if(map.containsKey(node)){
                return map.get(node);
            }
            else{
                map.put(node, new Node(node.val));
                return map.get(node);
            }
        }
        return null;
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node oldNode = head;
        Node newNode = new Node(head.val);
        map.put(oldNode, newNode);
        while (oldNode != null){
            newNode.random = getNode(oldNode.random);
            newNode.next = getNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
        // Node tmp = head;
        // while(tmp != null){
        //     // System.out.println(tmp.val);
        //     Node newTmp = new Node(tmp.val);
        //     Node next = tmp.next;
        //     tmp.next = newTmp;
        //     newTmp.next = next;
        //     tmp = next;
        // }
        // tmp = head;
        // while(tmp != null){
        //     // System.out.println(tmp.val);
        //     if (tmp.random == null){
        //         tmp.next.random = null;
        //     }
        //     else{
        //         tmp.next.random = tmp.random.next;
        //     }
        //     tmp = tmp.next.next;
        // }

        // Node dummy = new Node(-1);
        // Node curr = dummy;
        // tmp = head;
        // while(tmp != null){
        //     // System.out.println(tmp.val);
        //     curr.next = tmp.next;
        //     curr = curr.next;
        //     tmp.next = tmp.next.next;
        //     tmp = tmp.next;
        // }
        // return dummy.next;
    }
}