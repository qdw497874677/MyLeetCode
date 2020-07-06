//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        //如果当前节点和下一个节点都不为空，就可以比较这连个节点的值是否相等
        while (cur!=null && cur.next!=null){
            if (cur.val == cur.next.val){
                int temp = cur.val;
                cur = cur.next;
                while (cur.next!=null && cur.next.val==temp){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
