//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


package com.qdw.leetcode.editor.cn;
//Java：二进制求和
public class P67AddBinary{
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public String addBinary(String a, String b) {
                int m = a.length();
                int n = b.length();
                StringBuilder a1 = new StringBuilder(a);
                a1.reverse();
                StringBuilder b1 = new StringBuilder(b);
                b1.reverse();
                StringBuilder res = new StringBuilder();
                int i = 0;
                int x = 0;
                int aa = 0;
                int bb = 0;
                while((i<m || i<n) || x>0){
                    aa = bb = 0;
                    if(i<m && a1.charAt(i)=='1'){
                        aa = 1;
                    }
                    if(i<n && b1.charAt(i)=='1'){
                        bb = 1;
                    }
                    int temp = aa+bb+x;
                    if(temp>=2){
                        res.append(temp%2);
                        x = temp/2;
                    }else {
                        res.append(temp);
                        x = 0;
                    }
                    i++;
                }
                return res.reverse().toString();
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}
