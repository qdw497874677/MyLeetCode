//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package com.qdw.leetcode.editor.cn;
//Java：最大子序和
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果前面的值不为零，就加到当前。
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            res = Math.max(res,nums[i]);
        }
        return res;

//        int res = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum>0){
//                sum += num;
//            }else {
//                //如果sum小于零了，那就重置sum
//                sum = num;
//            }
//            res = Math.max(res,sum);
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
