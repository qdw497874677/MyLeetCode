//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：移除重复节点
public class P02_01RemoveDuplicateNodeLcci{
    public static void main(String[] args) {
        Solution solution = new P02_01RemoveDuplicateNodeLcci().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode p = head;
        while (p!=null){
            boolean add = set.add(p.val);
            if (!add){
                pre.next = p.next;
                p.next = null;
            }else {
                pre = pre.next;
            }
            p = pre.next;

        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
