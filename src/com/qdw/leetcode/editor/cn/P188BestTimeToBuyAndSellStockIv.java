//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;
//Java：买卖股票的最佳时机 IV
public class P188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //买卖一次股票需要两次步骤，如果k大于一半的天数，说明对于次数没有限制
        if (k>n/2){
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i]>prices[i-1]){
                    res += prices[i]-prices[i-1];
                }
            }
            return res;
        }
        //res[i][j]表示i次交易内，第j+1天的最大收益
        int[][] res = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = res[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.max(res[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, res[i - 1][j] - prices[j]);
            }
        }
        return res[k][n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
