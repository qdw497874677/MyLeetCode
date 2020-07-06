//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package com.qdw.leetcode.editor.cn;
//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || n==0){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        //cur为要删除的节点的前一个节点
        ListNode cur = dummyHead;
        while (p.next!=null){
            p = p.next;
            n--;
            //n=0的时候head是倒数第n个节点
            if (n<0){
                cur = cur.next;
            }
        }
        ListNode temp = cur.next;
        cur.next = temp.next;
        temp = null;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
