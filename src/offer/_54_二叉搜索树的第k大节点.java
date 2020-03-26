/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 解题思路：
 * 1.使用一个小根堆，并始终维护他的大小为k，每当有size>k 时，就poll()
 *   中序遍历二叉树按照上述规则添加到小根堆即可。
 * 2.不使用堆，借助二叉搜索树的性质，中序遍历二叉搜索树就是一个递增的序列。
 *   如果先访问右子树，再访问左子树的中序遍历就是一个递减的序列。
 *   在递归的过程中，进行计数，当计数到k的时候，此时访问的就是第k大的数。
 *   使用一个全局变量保存即可。
 */
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return pq.peek();
    }

    public void inOrder(TreeNode root, int k){
        if (root == null){
            return;
        }
        inOrder(root.left, k);
        pq.offer(root.val);
        if (pq.size() > k){
            pq.poll();
        }
        inOrder(root.right, k);
    }
}

class Solution {
    int res;
    int count = 1;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k){
        if (root == null){
            return;
        }
        inOrder(root.right, k);
        if (count == k){
            res = root.val;
            // 这里return之前也要记得+1
            count ++;
            return;
        }
        count ++;
        inOrder(root.left, k);
    }
}

