//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：字符串压缩
public class P01_06CompressStringLcci{
    public static void main(String[] args) {
        Solution solution = new P01_06CompressStringLcci().new Solution();
        // TO TEST
        System.out.println(solution.compressString("aabcccccaa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String compressString(String S) {
        char[] chars = S.toCharArray();
        int length = chars.length;
        if (length <= 2){
            return S;
        }
        StringBuffer sb = new StringBuffer();
        int count = 1;
        sb.append(chars[0]);
        for (int i = 1; i < length; i++) {
            //如果sb的最后一个字符和当前i位置的字符相等，那么这么字符的数量+1
            if (sb.charAt(sb.length()-1) == chars[i]){
                count++;
            }else {//如果不相等，把这个旧字符的数量拼接上，把新字符再拼接上重新计算数量
                sb.append(count).append(chars[i]);
                count = 1;
            }
            //sb的长度加上还没有拼上的数量的一个字符大于等于原字符串的长度，就返回原字符串了
            if (sb.length()+1>=length){
                return S;
            }
        }
        //最后把数量拼上
        sb.append(count);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
