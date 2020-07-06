//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 示例 : 
//
// 
//输入: [[1,2], [2,3], [3,4]]
//输出: 2
//解释: 最长的数对链是 [1,2] -> [3,4]
// 
//
// 注意： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

//Java：最长数对链
public class P646MaximumLengthOfPairChain{
    public static void main(String[] args) {
        Solution solution = new P646MaximumLengthOfPairChain().new Solution();
        // TO TEST [[1,2], [2,3], [3,4]]
        int[][] c = {{1,2},{2,3},{3,4}};
        System.out.println(solution.findLongestChain(c));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {

        int[] dp = new int[pairs.length];
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0]>pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[pairs.length-1]+1;









//        //dp[i]表示前i+1个数字对中的最长数对链的长度
//        int[] dp = new int[pairs.length];
//        //对pairs的数字对的第一位进行排序(前面-后面就是升序)
//        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
//        for (int i = 0; i < pairs.length; i++) {
//            //如果可以加在dp[j]的后面，那么就比较一下，加上还是不加那个更长，选长的
//            for (int j = 0; j < i; j++) {
//                if (pairs[i][0]>pairs[j][1]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//        }
//        return dp[pairs.length-1]+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
