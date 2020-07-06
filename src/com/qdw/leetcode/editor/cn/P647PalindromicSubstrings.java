//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划


package com.qdw.leetcode.editor.cn;
//Java：回文子串
public class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    count++;
                }
            }

        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
