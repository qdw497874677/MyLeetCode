//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


package com.qdw.leetcode.editor.cn;

import java.util.List;

//Java：排序链表
public class P148SortList{
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //用快慢指针将链表拆成两部分
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        //分治
        ListNode left = sortList(head);;
        ListNode right = sortList(temp);;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (left!=null && right!=null){
            if (left.val<right.val){
                p.next = left;
                p = p.next;
                left = left.next;
            }else {
                p.next = right;
                p = p.next;
                right = right.next;
            }
        }
        p.next = left!=null?left:right;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
