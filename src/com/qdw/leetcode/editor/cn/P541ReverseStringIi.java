//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于
// 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
//
// 示例:
//
//
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
// 要求:
//
//
// 该字符串只包含小写的英文字母。
// 给定字符串的长度和 k 在[1, 10000]范围内。
// 
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;
//Java：反转字符串 II
public class P541ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcd",4));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i+=2*k) {
            int j = i;
            int l = 0;
            if(i+k<length){
                l=i+k-1;
            }else {
                l=length-1;
            }
            while (j<l) {
                char temp = chars[j];
                chars[j] = chars[l];
                chars[l] = temp;
                j++;
                l--;
            }
        }
        return new String(chars);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
