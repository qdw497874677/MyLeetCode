//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package com.qdw.leetcode.editor.cn;
//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        String s = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //统计子串中的字符。
        int[] freq = new int[256];
        //起始状态，左指针i，右指针j。
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int res = 0;
        int n = s.length();
        while(i<n && j<n){
            //如果j指针没有遇到重复字符，将将这个字符加入到集合中。
            if(freq[chars[j]]==0){
                freq[chars[j++]]++;
                res = Math.max(res,j-i);
            }else{
                //如果j指针遇到重复字符，就不断地移动i指针，把i指针的字符从集合中排除
                // 直到i指针遇见j指针遇到的字符，将这个字符排除。
                freq[chars[i++]]--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
