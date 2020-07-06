//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package com.qdw.leetcode.editor.cn;

import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的右视图
public class P199BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (queue.size()==0){
                    res.add(poll.val);
                }
                if (poll.left!=null){
                    list.add(poll.left);
                }
                if (poll.right!=null){
                    list.add(poll.right);
                }
            }
            queue.addAll(list);
        }
        return res;





//        if (root==null){
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            List<TreeNode> list = new ArrayList<>();
//            while (!queue.isEmpty()){
//                TreeNode poll = queue.poll();
//                if (queue.size()==0){
//                    res.add(poll.val);
//                }
//                if (poll.left!=null){
//                    list.add(poll.left);
//                }
//                if (poll.right!=null){
//                    list.add(poll.right);
//                }
//            }
//            queue.addAll(list);
//        }
//        return res;
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
