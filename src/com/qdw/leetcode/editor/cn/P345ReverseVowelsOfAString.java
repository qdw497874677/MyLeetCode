//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        Set<Character> set = new HashSet<>();
        String yy = "aeiouAEIOU";
        for (int k = 0; k < yy.length(); k++) {
            set.add(yy.charAt(k));
        }
        char[] chars = s.toCharArray();
        while (i<=j){
            while (i<s.length()&&!set.contains(chars[i])){
                i++;
            }
            while (j>=0&&!set.contains(chars[j])){
                j--;
            }
            if (i<=j){
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
