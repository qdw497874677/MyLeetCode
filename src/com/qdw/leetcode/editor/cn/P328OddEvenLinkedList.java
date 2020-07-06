//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：奇偶链表
public class P328OddEvenLinkedList{
    public static void main(String[] args) {
        Solution solution = new P328OddEvenLinkedList().new Solution();
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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //把奇偶节点分别放到连个链表中
        ListNode vH1 = new ListNode(-1);
        ListNode q1 = vH1;
        ListNode vH2 = new ListNode(-1);
        ListNode q2 = vH2;
        int i = 1;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            if (i%2 == 1){
                i++;
                q1.next = cur;
                q1 = q1.next;
                q1.next = null;
            }else {
                i++;
                q2.next = cur;
                q2 = q2.next;
                q2.next = null;
            }
            cur = next;
        }
        q1.next = vH2.next;
        return vH1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
