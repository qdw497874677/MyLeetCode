//给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eleetminicoworoep"
//输出：13
//解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcodeisgreat"
//输出：5
//解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcbcbc"
//输出：6
//解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：每个元音包含偶数次的最长子字符串
public class P1371FindTheLongestSubstringContainingVowelsInEvenCounts{
    public static void main(String[] args) {
        Solution solution = new P1371FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        //存储每种奇偶性最早出现的位置，5位二进制
        int[] arr = new int[1<<5];
        Arrays.fill(arr,-1);
        String str = "aeiou";
        int res = 0;
        int status = 0;//00000
        arr[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (c==str.charAt(j)){
                    status ^= (1<<j);
                    break;
                }
            }
            if (arr[status] >= 0){
                //和当前奇偶情况的最早位置之差，就是包含偶数个元音的子串长度。
                //因为，奇数减奇数等于偶数，偶数减偶数等于偶数。
                res = Math.max(res,i+1 - arr[status]);
            }else {
                //记录当前奇偶情况最早出现的位置
                arr[status] = i+1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
