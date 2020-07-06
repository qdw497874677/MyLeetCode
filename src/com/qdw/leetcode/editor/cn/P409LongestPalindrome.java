//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表


package com.qdw.leetcode.editor.cn;
//Java：最长回文串
public class P409LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {

        int res = 0;
        int[] arr = new int[256];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        for (int i : arr) {
            res += (i/2)*2;
        }

        if (res < s.length()){
            res++;
        }
        return res;










//        int res=0;
//        int[] counts = new int[256];
//
//        for(char c:s.toCharArray()){
//            counts[c]++;
//        }
//        for(int count:counts){
//            //取到每个字符数量的最大的偶数
//            res += (count/2)*2;
//        }
//        if(res < s.length()){//说明有字符数量为奇数，回文串里再加上一个基数在中间
//            res++;
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
