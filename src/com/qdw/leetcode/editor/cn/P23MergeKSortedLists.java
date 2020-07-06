//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package com.qdw.leetcode.editor.cn;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：合并K个排序链表
public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length==0){
            return null;
        }
        if (length==1){
            return lists[0];
        }
        //如果数组中元素只有两个，就归并两个链表
        if (length==2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        //把链表数组分成两个
        int mid = length/2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[length-mid];
        for (int i = mid; i < length; i++) {
            l2[i-mid] = lists[i];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));






//        Queue<ListNode> heap = new PriorityQueue<>((a,b)->{
//            return a.val-b.val;
//        });
//        ListNode p;
//        for (int i = 0; i < lists.length; i++) {
//            p = lists[i];
//            while (p!=null){
//                heap.add(p);
//                p = p.next;
//            }
//        }
//        ListNode dummyHead = new ListNode(-1);
//        p = dummyHead;
//        while (!heap.isEmpty()){
//            p.next = heap.poll();
//            p = p.next;
//        }
//        p.next = null;
//        return dummyHead.next;
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode head = null;
        if (l1.val<=l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
