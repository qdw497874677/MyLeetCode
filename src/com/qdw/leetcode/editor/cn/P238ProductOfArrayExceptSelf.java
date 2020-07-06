//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组


package com.qdw.leetcode.editor.cn;
//Java：除自身以外数组的乘积
public class P238ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        //k记录i左边的值相乘，将值放到结果中
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        //k记录i右边的值相乘，将值放到结果中
        k = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        //从左从右各走一半，res中就为除自己以为左右相乘的值
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
