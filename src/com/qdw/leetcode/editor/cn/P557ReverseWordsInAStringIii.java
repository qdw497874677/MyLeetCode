//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 示例 1:
//
//
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;
//Java：反转字符串中的单词 III
public class P557ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < ss.length; k++) {
            StringBuffer temp = new StringBuffer();
            if(k == ss.length-1){
                temp.append(ss[k]).reverse();
                sb.append(temp);
            }else {
                temp.append(ss[k]).reverse();
                sb.append(temp);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
