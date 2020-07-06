//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索


package com.qdw.leetcode.editor.cn;
//Java：字符串解码
public class P394DecodeString{
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String src;
        int ptr;
        public String decodeString(String s) {
            src = s;
            ptr = 0;
            return getString();
        }
        //解析String
        public String getString() {
            //如果指针到了最后，后者遇到了右括号，就返回
            if (ptr == src.length() || src.charAt(ptr) == ']') {
                // String -> EPS
                return "";
            }
            char cur = src.charAt(ptr);
            int repTime = 1;
            String ret = "";
            //如果当前字符是数字，就获取这个数字，作为字符串的系数
            if (Character.isDigit(cur)) {
                //获取了系数
                repTime = getDigits();
                // 跳过左括号
                ++ptr;
                // 解析 String
                String str = getString();
                // 跳过右括号
                ++ptr;
                // 构造字符串，系数个字符串相连
                while (repTime-- > 0) {
                    ret += str;
                }
            } else if (Character.isLetter(cur)) {
                // 如果是字符，就获取连续的字符，加入待返回的结果中
                ret = String.valueOf(src.charAt(ptr++));
            }
            //放回当前解析出的字符串，和接下来解析的字符串
            return ret + getString();
        }
        // 获取数字
        public int getDigits() {
            int ret = 0;
            //只要后面还是数字，就全部按位加起来，组成一个数字。
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                ret = ret * 10 + src.charAt(ptr++) - '0';
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
