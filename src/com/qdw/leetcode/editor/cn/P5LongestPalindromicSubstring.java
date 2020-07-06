//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package com.qdw.leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            boolean[][] dp = new boolean[len][len];
            // 初始化，只有一个字符肯定是回文
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            int maxLen = 1;
            int start = 0;
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    //如果两边的字符相等，才有可能是回文
                    if (s.charAt(i) == s.charAt(j)) {
                        //小于3个三个字符，一定是回文
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            //大于三个，如果中间的是回文，那这个就是回文
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {//首尾字符不等，肯定不是回文
                        dp[i][j] = false;
                    }
                    // 如果是回文，就比较，找出长的
                    if (dp[i][j]) {
                        int curLen = j - i + 1;
                        if (curLen > maxLen) {
                            maxLen = curLen;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
