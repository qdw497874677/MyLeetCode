//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        //叶子节点，把值放到字符串集合中
        if (root.left==null && root.right==null){
            res.add(String.valueOf(root.val));
            return res;
        }
        //把当前节点的值加到左子树路径的前面
        List<String> left = binaryTreePaths(root.left);
        for (String s : left) {
            res.add(String.valueOf(root.val)+"->"+s);
        }
        //把当前节点的值加到右子树路径的前面
        List<String> right = binaryTreePaths(root.right);
        for (String s : right) {
            res.add(String.valueOf(root.val)+"->"+s);
        }
        return res;
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
