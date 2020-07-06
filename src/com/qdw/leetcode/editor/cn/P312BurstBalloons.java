//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 
//left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划


package com.qdw.leetcode.editor.cn;
//Java：戳气球
public class P312BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new P312BurstBalloons().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //数组两边各加一个1。
        int[] arr = new int[n+2];
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }
        arr[0] = arr[n+1] = 1;
        //dp[i][j]表示戳爆从i到j的气球得到的硬币。
        int[][] dp = new int[n+2][n+2];
        //第一层循环：表示戳气球的长度
        for (int len = 1; len <= n; len++) {
            //第二层循环：表示戳气球范围所在的位置。比如上一层表示戳3个气球，这一层就表示从每个位置开始的3个气球范围。
            for (int i = 1; i <= n - len + 1; i++) {
                //从i到j闭区间的气球都要戳。
                int j = i+len-1;
                //第三层循环：k表示最后要戳的气球。之所以用k表示最后戳，是因为如果表示先戳，那么左右的子问题并不独立。所以需要逆向思考。
                for (int k = i; k <= j; k++) {
                    //先戳左边dp[i][k-1]，和右边dp[k+1][j]，最后是当前k：arr[i-1]*arr[k]*arr[j+1]
                    dp[i][j] = Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j+1]);
                }
            }
        }
        return dp[1][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
