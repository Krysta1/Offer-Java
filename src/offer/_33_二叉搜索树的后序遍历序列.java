/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 解题思路：
 * 1.递归：在整个postorder数组中，最后一个是根节点root.val。
 *   根据根节点到前面数组中去判断，遇到的第一个比root.val大的值，标记为index作为下次递归的分界。
 *   如果在index之后的位置上，有比root.val还小的值。那么就返回false（这里逻辑想得清楚，但是实现的时候调试了好久）
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int l, int r){
        if (l >= r) return true;
        int index = l;
        boolean res = true;
        for (int i = l; i <= r; i ++){
            // 虽然题解使用while循环的方式很好，我自己的想法一直不过的原因是 判断中要加上=。
            if(postorder[i] >= postorder[r]){
                index = i;
                break;
            }
        }
        // while (postorder[index] < postorder[r]) index ++;
        int tmp = index;
        while (postorder[index] > postorder[r]) index ++;
        if (index != r) res = false;
        return res && helper(postorder, l, tmp - 1) && helper(postorder, tmp, r - 1);
    }
}