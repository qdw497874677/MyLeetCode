//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计


package com.qdw.leetcode.editor.cn;

import java.util.Deque;
import java.util.Stack;

//Java：最小栈
public class P155MinStack{
    public static void main(String[] args) {
        MinStack solution = new P155MinStack().new MinStack();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private int min;
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            //只入当前最小的值
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }
        public void push(int x) {
            dataStack.add(x);
            min = Math.min(min,x);
            //压入当前最小的值
            minStack.add(min);
        }
        public void pop() {
            dataStack.pop();
            minStack.pop();
            //最小值min就是栈顶的值，如果栈空就是Integer.MAX_VALUE
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
        public int top() {
            return dataStack.peek();
        }
        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
