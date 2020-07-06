//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：反转链表 II
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode p = head;
        int i = 1;
        //先找到要反转的第一个。
        while (i<m){
            pre = p;
            p = p.next;
            i++;
        }
        //找到要反转的最后一个。
        ListNode next = p;
        while (i<n){
            next = next.next;
            i++;
        }
        //把要反转的最后一个和后面的节点断开，准备常规的反转。
        ListNode temp = next;
        next = next.next;
        temp.next = null;
        //把反转第一个的上一个节点和反转最后一个的下一个节点连接。
        pre.next = next;
        //头插法把节点插入到pre的后面。
        while (p!=null){
            temp = p.next;
            p.next = pre.next;
            pre.next = p;
            p = temp;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
