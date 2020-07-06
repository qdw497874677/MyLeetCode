//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count;
        int i = 0;
        LinkedList<Integer> deque;
        while (!queue.isEmpty()){
            //一层一层处理
            count = queue.size();
            deque = new LinkedList<>();
            while (count>0) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                if (i%2==0){
                    //偶数用队列
                    deque.addLast(poll.val);
                }else {
                    //奇数用栈
                    deque.addFirst(poll.val);
                }
                count--;
            }
            res.add(deque);
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
