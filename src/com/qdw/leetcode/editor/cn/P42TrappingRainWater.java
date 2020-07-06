//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


package com.qdw.leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()]<height[i]) {
                Integer pop = stack.pop();
                while (!stack.isEmpty() && height[pop] == height[stack.peek()]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    Integer left = stack.peek();
                    res += (Math.min(height[i],height[left])-height[pop])*(i-left-1);
                }
            }
            stack.add(i);
        }


//            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                //找到能盛雨的底
//                int curIdx = stack.pop();
//                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
//                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
//                    stack.pop();
//                }
//                if (!stack.isEmpty()) {
//                    int stackTop = stack.peek();
//                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
//                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
//                    // i - stackTop - 1 是雨水的宽度。
//                    res += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
//                }
//            }
//            stack.add(i);
//        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
