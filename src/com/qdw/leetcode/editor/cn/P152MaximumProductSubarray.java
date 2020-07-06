//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


package com.qdw.leetcode.editor.cn;
//Java：乘积最大子数组
public class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
//        int n = nums.length;
//        //两个数组，一个存最大的，一个保存最小的，每次都互相比较下。
//        int[] dpmax = new int[n];
//        dpmax[0] = nums[0];
//        int[] dpmin = new int[n];
//        dpmin[0] = nums[0];
//        int res = nums[0];
//        for (int i = 1; i < n; i++) {
//            dpmax[i] = Math.max(nums[i],Math.max(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]));
//            dpmin[i] = Math.min(nums[i],Math.min(dpmin[i-1]*nums[i],dpmax[i-1]*nums[i]));
//            res = Math.max(res,dpmax[i]);
//        }
//        return res;

//        int n = nums.length;
//        int min = nums[0];
//        int max = nums[0];
//        int res = nums[0];
//        for (int i = 1; i < n; i++) {
//            //防止min去比较修改后的max。
//            int tempMax = max;
//            int tempMin = min;
//            max = Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
//            min = Math.min(nums[i],Math.min(tempMin*nums[i],tempMax*nums[i]));
//            res = Math.max(max,res);
//        }
//        return res;

        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(nums[i],Math.max(nums[i]*tempMax,nums[i]*tempMin));
            min = Math.min(nums[i],Math.min(nums[i]*tempMax,nums[i]*tempMin));
            res = Math.max(res,max);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
