//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。 
//
// 示例 : 
//给定二叉树 
//
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树


package com.qdw.leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：二叉树的直径
public class P543DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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

    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        depth(root);
        return res;
    }
    //返回这个节点的子树的最长深度，每一次计算，都比较下找出最长路径
    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        res = Math.max(left+right,res);
        return Math.max(left,right)+1;
    }

}
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//leetcode submit region end(Prohibit modification and deletion)

}
