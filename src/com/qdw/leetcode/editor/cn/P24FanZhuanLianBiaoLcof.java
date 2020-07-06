//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：反转链表
public class P24FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new P24FanZhuanLianBiaoLcof().new Solution();
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
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //p指向要头插到前面的节点
        ListNode p = head;
        //temp用来存储p的下一个节点
        ListNode temp = null;
        //newHead指向新的头结点
        ListNode newHead = null;
        while (p!=null){
            temp = p.next;
            p.next = newHead;
            newHead = p;
            p = temp;
        }
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
