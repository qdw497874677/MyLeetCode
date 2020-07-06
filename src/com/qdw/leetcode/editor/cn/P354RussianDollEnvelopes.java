//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：俄罗斯套娃信封问题
public class P354RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // TO TEST
        int[][] test = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(solution.maxEnvelopes(test));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //现根据长或者宽进行排序，之后就是找最大递增子序列
        Arrays.sort(envelopes,(a,b)->{
            return a[0]-b[0];
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果长和宽都大，就判断当前长度的最大递增子序列
                //相同长/宽只能选一个，所以这里判断一下nvelopes[i][0]>envelopes[j][0]
                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
