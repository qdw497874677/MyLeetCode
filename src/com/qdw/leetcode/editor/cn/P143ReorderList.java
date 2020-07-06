//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;

import java.util.List;

//Java：重排链表
public class P143ReorderList{
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }
        ListNode p = head;
        ListNode q = head.next;
        //用快慢指针，把链表拆成两半
        //快慢指针，起始位置一前一后
        while (q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        ListNode newHead = null;
        q = p.next;
        p.next = null;
        ListNode temp = null;
        //将后半个链表反转
        while (q!=null){
            temp = q.next;
            q.next = newHead;
            newHead = q;
            q = temp;
        }
        p = head;
        q = newHead;
        //两个链表进行拼接
        while (p!=null && q!=null){
            temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
