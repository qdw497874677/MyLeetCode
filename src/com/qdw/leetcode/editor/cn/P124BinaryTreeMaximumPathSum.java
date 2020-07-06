//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


package com.qdw.leetcode.editor.cn;
//Java：二叉树中的最大路径和
public class P124BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if (root==null){
            return 0;
        }
        //左边最大的路径或者不选左边即为0
        int left = Math.max(0,helper(root.left));
        //右边最大的路径或者不选右边即为0
        int right = Math.max(0,helper(root.right));
        //比较通过本节点的最大路径和最大值max
        max = Math.max(max,left+root.val+right);
        //返回自己加上比较大的路径值
        return root.val+Math.max(left,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
