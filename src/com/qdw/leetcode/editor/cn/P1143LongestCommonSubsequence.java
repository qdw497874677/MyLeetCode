//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;
//Java：最长公共子序列
public class P1143LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new P1143LongestCommonSubsequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        //dp[i][j]表示text1前i字符串和text2前j字符串的最长公共子序列
        int[][] dp = new int[l1+1][l2+1];
        //j=0 j=0的一行一列都是0，是基础
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                //如果两个字符相等，那么当前位置的最长公共子序列长度比之前多+1
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    //如果不相等，那么当前的最长公共子序列长度就要选一个之前的最大的，两个里选最大的
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
