//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
class Command{
    String s;
    TreeNode node;
    public Command(String s, TreeNode node){
        this.s = s;
        this.node = node;
    }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<Command> stack = new ArrayDeque<>();
        stack.addFirst(new Command("go",root));
        while (!stack.isEmpty()){
            Command command = stack.pollFirst();
            if ("print".equals(command.s)){
                res.add(command.node.val);
            }else {
                if (command.node.right!=null){
                    stack.addFirst(new Command("go",command.node.right));
                }
                stack.addFirst(new Command("print",command.node));
                if (command.node.left!=null){
                    stack.addFirst(new Command("go",command.node.left));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
