//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;
//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
//        //开始的时候没有股票，没有收益
//        int dp_i_0 = 0;
//        //开始的时候有股票，不可能
//        int dp_i_1 = Integer.MIN_VALUE;
//        // 代表 dp[i-2][0]，因为它表示上上次的数据，所以需要一个单独的变量来保存
//        int dp_pre_0 = 0;
//        for (int i = 0; i < n; i++) {
//            int temp = dp_i_0;
//            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
//            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
//            dp_pre_0 = temp;
//        }
//        return dp_i_0;

        if (n == 0){
            return 0;
        }
        int[] buy = new int[n];
        //手里有股票，不操作
        int[] s1 = new int[n];
        int[] sell = new int[n];
        //手里没有股票，不操作
        int[] s2 = new int[n];
        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = s2[i-1] - prices[i];
            s1[i] = Math.max(buy[i-1],s1[i-1]);
            sell[i] = Math.max(buy[i-1],s1[i-1])+prices[i];
            s2[i] = Math.max(sell[i-1],s2[i-1]);
        }
        return Math.max(sell[n-1],s2[n-1]);




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
