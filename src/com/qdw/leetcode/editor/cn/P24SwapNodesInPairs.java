//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：两两交换链表中的节点
public class P24SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur1 = null;
        ListNode cur2 = null;
        while (pre.next!=null && pre.next.next!=null){
            cur1 = pre.next;
            cur2 = cur1.next;
            cur1.next = cur2.next;
            cur2.next = cur1;
            pre.next = cur2;
            pre = cur1;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
