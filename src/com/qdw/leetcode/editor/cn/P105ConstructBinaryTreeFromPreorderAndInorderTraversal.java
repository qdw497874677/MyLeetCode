//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1,0,map);
    }
    public TreeNode buildTree(int[] preorder,int preL,int preR,int inL,Map<Integer,Integer> map){
        if (preL>preR){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int i = map.get(preorder[preL]);
        int leftTreeSize = i - inL;
        root.left = buildTree(preorder,preL+1,preL+leftTreeSize,inL,map);
        //中序从inL+leftTreeSize+1开始，后面的就包含
        root.right = buildTree(preorder,preL+leftTreeSize+1,preR,inL+leftTreeSize+1,map);
        return root;
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
