//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树


package com.qdw.leetcode.editor.cn;
//Java：删除二叉搜索树中的节点
public class P450DeleteNodeInABst{
    public static void main(String[] args) {
        Solution solution = new P450DeleteNodeInABst().new Solution();
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
    //递归返回包含被删除节点的数的根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        //如果等于key，说明这个是要删除的节点。
        if (root.val==key){
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }else {
                //当这个将要被删除的节点有左右孩子
                //需要将左孩子移到右孩子的最左边
                TreeNode node = root.right;
                //找到最左边
                while (node.left!=null){
                    node = node.left;
                }
                //把root的左孩子放到最左边
                node.left = root.left;
                return root.right;
            }
        }else if (root.val>key){
            //左子树中存在被删除的节点，把删除的新子树最为root的左孩子
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
