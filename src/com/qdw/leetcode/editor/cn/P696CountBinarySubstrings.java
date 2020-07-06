//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 
//
// 重复出现的子串要计算它们出现的次数。 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 注意： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;
//Java：计数二进制子串
public class P696CountBinarySubstrings{
    public static void main(String[] args) {
        Solution solution = new P696CountBinarySubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
        int preLen = 0;//上一个连续最长字符数量
        int curLen = 1;//当前最长连续字符数量
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;//连续数量增加
            } else {
                //如果和上一个字符不相等，重置当前连续最长
                preLen = curLen;
                curLen = 1;
            }
            //如果上一个最长字符数量比当前连续字符数量，就存在一个二进制数量

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
