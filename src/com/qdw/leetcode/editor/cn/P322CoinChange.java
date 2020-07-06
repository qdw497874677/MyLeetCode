//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class P322CoinChange{
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        //初始值，为了判断刚好等于总钱的硬币面额
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];






//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0] = 0;
//        for (int i = 1; i < amount+1; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                //硬币面值比当前总金额小，说明有可能用到
//                if(coins[j]<=i){
//                    //放了这个硬币的数量和不放的数量，选小的那个
//                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
//                }
//            }
//        }
//        return dp[amount]>amount?-1:dp[amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
