//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Java：下一个更大元素 II
public class P503NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        int[] a = new int[]{1,2,3};
        solution.nextGreaterElements(a);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {


        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i%nums.length]){
                res[stack.pop()] = nums[i%nums.length];
            }
            if (i<nums.length){
                stack.add(i);
            }

        }
        return res;





//        //单调栈
//        int n = nums.length;
//        int[] res = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        //结果数组的值填充为-1
//        Arrays.fill(res,-1);
//        for (int curi = 0; curi < n*2; curi++) {
//            //相当于循环回到了前面
//            int i = curi%n;
//            //若果不空栈，且当前数大于栈顶数，就出栈，结果中保存栈顶数的右边最大数为当前数
//            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
//                res[stack.pop()] = nums[i];
//            }
//            if(curi<n){
//                stack.add(curi);
//            }
//        }
//
//
//        return res;






//        int n = nums.length;
//        Stack<Integer> stack = new Stack<>();
//        int[] a = new int[n];
//        Arrays.fill(a,-1);
//        //因为是循环数据，所以最长考虑两个n的数
//        for (int i = 0; i < n * 2; i++) {
//            //只处理n个
//            int num = nums[i%n];
//            while (!stack.isEmpty() && nums[stack.peek()]<num){
//                a[stack.pop()] = num;
//            }
//            //栈里面放接下来要处理的位置
//            if(i<n){
//                stack.add(i);
//            }
//        }
//
//
//        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
