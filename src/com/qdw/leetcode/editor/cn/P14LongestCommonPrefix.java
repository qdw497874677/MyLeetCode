//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package com.qdw.leetcode.editor.cn;
//Java：最长公共前缀
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        if (strs==null || strs.length==0){
//            return "";
//        }
//        String res = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            if ("".equals(res)){
//                return res;
//            }
//            res = help(res,strs[i]);
//        }
//        return res;
//    }
//    public String help(String a,String b){
//        int l = Math.min(a.length(),b.length());
//        int i = 0;
//        for (i = 0; i < l; i++) {
//            if (a.charAt(i) != b.charAt(i)){
//                break;
//            }
//
//        }
//        return a.substring(0,i);
//    }
//}
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                minLength = Math.min(minLength, str.length());
            }
            int low = 0, high = minLength;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (isCommonPrefix(strs, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return strs[0].substring(0, low);
        }

        public boolean isCommonPrefix(String[] strs, int length) {
            String str0 = strs[0].substring(0, length);
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                String str = strs[i];
                for (int j = 0; j < length; j++) {
                    if (str0.charAt(j) != str.charAt(j)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
