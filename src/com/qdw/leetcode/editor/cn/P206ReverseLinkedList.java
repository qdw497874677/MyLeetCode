//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;
//Java：反转链表
public class P206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
        if (head==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //不断地把head后面的节点头插到虚拟头结点后面
        while(head.next!=null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        head.next = null;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
