//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：解码方法
public class P91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        // TO TEST
        System.out.println(solution.numDecodings("12258"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length+1];
        dp[0] = 1;
        dp[1] = chars[0]-'0'==0?0:1;
        for (int i = 2; i < chars.length+1; i++) {
            //当前位的值如果是0，有没有这位没有区别，dp[i]的值等于dp[i-1]
            int one = chars[i-1]-'0';
            if (one != 0){
                dp[i] += dp[i-1];
            }
            //如果前一位的值是0，就没有必要考虑这两位放在一起了
            //如果前一位不是0，那么这两位就肯定是10以上
            if (chars[i-2]-'0' == 0){
                continue;
            }
            //如果这两位小于等于26，就可拆可合，上上位的值再加上
            int two = (chars[i-2]-'0')*10+(chars[i-1]-'0');
            if (two <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[chars.length];

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
