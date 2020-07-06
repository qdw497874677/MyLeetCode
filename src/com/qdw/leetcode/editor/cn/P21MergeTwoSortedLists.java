//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：合并两个有序链表
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1!=null && p2!=null){
            if (p1.val<p2.val){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p1!=null){
            p.next = p1;
        }else if (p2!=null){
            p.next = p2;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
