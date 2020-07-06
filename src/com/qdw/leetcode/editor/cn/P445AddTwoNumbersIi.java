//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package com.qdw.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

//Java：两数相加 II
public class P445AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果的头结点
        ListNode head = null;
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        ListNode p = l1;
        while(p!=null){
            stack1.addFirst(p.val);
            p = p.next;
        }
        p = l2;
        while (p!=null){
            stack2.addFirst(p.val);
            p = p.next;
        }
        int pre = 0;
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            sum = 0;
            if (!stack1.isEmpty()){
                sum += stack1.pollFirst();
            }
            if (!stack2.isEmpty()){
                sum += stack2.pollFirst();
            }
            sum += pre;
            pre = sum/10;
            //头插法
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = head;
            head = listNode;
        }
        if (pre!=0){
            ListNode listNode = new ListNode(pre);
            listNode.next = head;
            head = listNode;
        }
        return head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
