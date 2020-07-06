//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.List;

//Java：单词拆分
public class P139WordBreak{
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length()+1];
//        dp[0] = true;
//        //物品放在内层循环，不断循环物品
//        for (int i = 1; i <= s.length(); i++) {
//            for (String s1 : wordDict) {
//                int len = s1.length();
//                //如果这个单词长度比背包小，且和当前背包后面的相等，就可以进行判断，
//                if (len<=i && s1.equals(s.substring(i-len,i))){
//                    dp[i] = dp[i] || dp[i-len];
//                }
//            }
//        }
//        return dp[s.length()];

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int l = word.length();
                //当前单词要比当前背包小 且 与背包后面相等，就可以进行判断。否则不用重新判断了。
                if (l<=i && word.equals(s.substring(i-l,i))){
                    dp[i] = dp[i] || dp[i-l];
                }
            }
        }
        return dp[n];








    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
