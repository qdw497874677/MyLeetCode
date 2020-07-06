//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package com.qdw.leetcode.editor.cn;

import java.util.List;

//Java：回文链表
public class P234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode pre = p;
        while (q!=null && q.next!=null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode newHead = null;
        ListNode temp = null;
        while (p!=null){
            temp = p.next;
            p.next = newHead;
            newHead = p;
            p = temp;
        }
        p = head;
        q = newHead;
        while (p!=null && q!=null){
            if (p.val!=q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
