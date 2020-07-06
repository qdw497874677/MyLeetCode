//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划


package com.qdw.leetcode.editor.cn;
//Java：买卖股票的最佳时机含手续费
public class P714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new P714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            //sell[i]表示第i天卖出股票的情况下的收益
            int[] sell = new int[n];
            //s1[i]表示第i天手里有股票没有卖情况下的收益
            int[] s1 = new int[n];
            //buy[i]表示第i天买入股票的情况下的收益
            int[] buy = new int[n];
            //s2[i]表示第i天手里没有股票没有买情况下的收益
            int[] s2 = new int[n];
            sell[0] = 0;
            s1[0] = 0;
            //第0天，手里有股票是不可能的，保证第一次买了股票后的收益是0
            buy[0] = -prices[0];
            s2[0] = -prices[0];
            for (int i = 1; i < n; i++) {
                sell[i] = Math.max(buy[i-1],s2[i-1])+prices[i]-fee;
                s1[i] = Math.max(sell[i-1],s1[i-1]);
                buy[i] = Math.max(sell[i-1],s1[i-1])-prices[i];
                s2[i] = Math.max(buy[i-1],s2[i-1]);
            }
            return Math.max(sell[n-1],s1[n-1]);


//            int n = prices.length;
//            int dp_i_0 = 0;
//            int dp_i_1 = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                int temp = dp_i_0;
//                dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
//                dp_i_1 = Math.max(dp_i_1,temp-prices[i]-fee);
//            }
//            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
