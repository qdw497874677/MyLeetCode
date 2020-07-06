//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划


package com.qdw.leetcode.editor.cn;
//Java：目标和
public class P494TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        //如果能找到数字和为W的正数，那剩下的都为数字都为负数，就是符合要求的。
//        int W = (sum + S)/2;
//        //数字和比S小，肯定不符合
//        //sum + S如果不是被分成两份，即不是偶数，是不符合的
//        if (sum<S || (sum + S)%2!=0){
//            return 0;
//        }
//        int[] dp = new int[W+1];
//        //求多少种，初始0为1
//        dp[0] = 1;
//        //01背包
//        for (int num : nums) {
//            for (int j = W; j >= num; j--) {
//                dp[j] = dp[j] + dp[j-num];
//            }
//        }
//        return dp[W];



        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //数字和比S小，肯定不符合
        //sum + S如果不是被分成两份，即不是偶数，是不符合的
        if (sum<S || (sum+S)%2!=0){
            return 0;
        }
        //如果能找到数字和为W的正数，那剩下的都为数字都为负数，就是符合要求的。
        int W = (sum+S)/2;
        int[] dp = new int[W+1];
        dp[0] = 1;
        for (int num : nums) {
            //01背包，因为只考虑之前物品和之前背包的结果，所以为了避免被心的结果影响，倒序遍历
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i-num];
            }
        }
        return dp[W];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
