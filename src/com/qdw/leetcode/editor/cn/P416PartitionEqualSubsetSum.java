//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;
//Java：分割等和子集
public class P416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2!=0){
            return false;
        }
        int w = sum/2;
        boolean[] dp = new boolean[w+1];
        dp[0] = true;
        for (int num : nums) {
            //为了防止新值提前覆盖旧值，从后向前
            for (int i = w; i >= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[w];








//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        //如果总和不是偶数，那肯定分割不了相等的子集
//        if (sum%2 != 0){
//            return false;
//        }
//        int W = sum/2;
//        //dp[i]表示存在和为i的子集
//        boolean[] dp = new boolean[W+1];
//        dp[0] = true;
//        for (int num : nums) {
//            //为了防止新值提前覆盖旧值，从后向前
//            for (int j = W; j >= num; j--) {
//                dp[j] = dp[j] || dp[j-num];
//            }
//        }
//        return dp[W];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
