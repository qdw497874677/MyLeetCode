//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package com.qdw.leetcode.editor.cn;
//Java：验证回文串
public class P125ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        //统一转成大写：ch & 0b11011111 简写：ch & 0xDF
        //统一转成小写：ch | 0b00100000 简写：ch | 0x20
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if ((c>='a'&&c<='z')||(c>='0'&&c<='9')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
