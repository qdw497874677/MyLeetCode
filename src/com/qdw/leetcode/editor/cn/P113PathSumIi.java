//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        //如果是叶子节点，并且值之和等于sum，就创建一个集合递归的把值放进去
        if (sum==root.val && root.left==null && root.right==null){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        for (List<Integer> integers : left) {
            integers.add(0,root.val);
            lists.add(integers);
        }
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for (List<Integer> integers : right) {
            integers.add(0,root.val);
            lists.add(integers);
        }
        return lists;
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
