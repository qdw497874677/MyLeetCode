//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> nums;
        int count = 0;
        while (!queue.isEmpty()){
            count = queue.size();
            nums = new ArrayList<>();
            while (count>0){
                TreeNode poll = queue.poll();
                nums.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                count--;
            }
            res.add(nums);
        }
        return res;





//        List<List<Integer>> res = new ArrayList<>();
//        if (root==null){
//            return res;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<TreeNode> list;
//        List<Integer> nums;
//        while (!queue.isEmpty()){
//            list = new ArrayList<>();
//            nums = new ArrayList<>();
//            while (!queue.isEmpty()){
//                TreeNode poll = queue.poll();
//                nums.add(poll.val);
//                if (poll.left!=null){
//                    list.add(poll.left);
//                }
//                if (poll.right!=null){
//                    list.add(poll.right);
//                }
//            }
//            queue.addAll(list);
//            res.add(nums);
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
