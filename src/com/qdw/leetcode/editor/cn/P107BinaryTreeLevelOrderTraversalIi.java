//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<List<Integer>> stack = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list;
        List<Integer> nums;
        while (!queue.isEmpty()){
            list = new ArrayList<>();
            nums = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                nums.add(poll.val);
                if (poll.left!=null){
                    list.add(poll.left);
                }
                if (poll.right!=null){
                    list.add(poll.right);
                }
            }
            queue.addAll(list);
            stack.addFirst(nums);
        }
        while (!stack.isEmpty()){
            res.add(stack.pollFirst());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
