//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
    public Command(String s,TreeNode node){
        this.s = s;
        this.node = node;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                stack.addFirst(new Command("print",command.node));
                if (command.node.right!=null){
                    stack.addFirst(new Command("go",command.node.right));
                }
                if (command.node.left!=null){
                    stack.addFirst(new Command("go",command.node.left));
                }
            }
        }
        return res;






//        List<Integer> res = new ArrayList<>();
//        if (root==null){
//            return res;
//        }
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        Deque<Integer> ans = new ArrayDeque<>();
//        stack.addFirst(root);
//        while (!stack.isEmpty()){
//            TreeNode treeNode = stack.pollFirst();
//            ans.addFirst(treeNode.val);
//            if (treeNode.left!=null){
//                stack.addFirst(treeNode.left);
//            }
//            if (treeNode.right!=null){
//                stack.addFirst(treeNode.right);
//            }
//
//        }
//        while (!ans.isEmpty()){
//            res.add(ans.pollFirst());
//        }
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        return res;


//        if (root==null){
//            return new ArrayList<>();
//        }
//
//        List<Integer> res = new ArrayList<>();
//        res.addAll(postorderTraversal(root.left));
//        res.addAll(postorderTraversal(root.right));
//        res.add(root.val);
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}
