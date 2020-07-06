//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索


package com.qdw.leetcode.editor.cn;
//Java：平衡二叉树
public class P110BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        //比较两个子树的深度差的绝对值，大于一说明不平衡
        if (Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }
        //接着检查两个子树是不是平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = depth(root.left)+1;
        int right = depth(root.right)+1;
        //返回最深的子树
        return left>right?left:right;
    }
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
