//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


package com.qdw.leetcode.editor.cn;
//Java：分隔链表
public class P86PartitionList{
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        //vH是一个虚拟头节点，他带头的链表节点都是比x小的，p指针为这个链表的最后一个
        ListNode vH = new ListNode(-1);
        ListNode p = vH;
        //cur为原链表中正在处理的节点，如果小于x就尾接到p后面。
        ListNode cur = head;
        ListNode next;
        ListNode pre = null;
        while (cur!=null){
            next = cur.next;
            if (cur.val<x){
                if (cur==head){
                    head = next;
                }
                if (pre!=null){
                    pre.next = next;
                }
                p.next = cur;
                p = p.next;
            }else {
                pre = cur;
            }
            cur = next;
        }
        //两个链表连接起来。
        p.next = head;
        return vH.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
