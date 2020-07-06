//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapT = new HashMap<>();
        Map<Character,Integer> mapCur = new HashMap<>();
        int ns = s.length();
        int nt = t.length();
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        for (char c : t.toCharArray()) {
//            mapT.put(c,mapT.getOrDefault(c,0)+1);
            freqT[c]++;
        }
        int i = 0;
        int j = -1;

        int len = ns+1;
        int resL = -1;
        int resR = ns;
        while(i<ns && j<ns){
            ++j;
            //当j没有越界 且 t中包j所在的字符，把字符加入
//            if (j < ns && mapT.containsKey(s.charAt(j))) {
//                mapCur.put(s.charAt(j), mapCur.getOrDefault(s.charAt(j), 0) + 1);
//            }
            if (j<ns && freqT[s.charAt(j)]>0){
                freqS[s.charAt(j)]++;
            }
            //如果此时包含，且i不必j大，记录一次，然后把i的字符移除，i++
//            while (check(mapT,mapCur) && i <= j) {
            while (check(freqS,freqT) && i <= j) {
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    resL = i;
                    resR = i + len;
                }
//                if (mapT.containsKey(s.charAt(i))) {
//                    mapCur.put(s.charAt(i), mapCur.getOrDefault(s.charAt(i), 0) - 1);
//                }
                if (freqT[s.charAt(i)]>0){
                    freqS[s.charAt(i)]--;
                }
                ++i;
            }
        }
        return resL==-1 ? "" : s.substring(resL,resR);
    }
    public boolean check(int[] freqS,int[] freqT){
        for (int i = 0; i < freqT.length; i++) {
            if (freqS[i]<freqT[i]){
                return false;
            }
        }
        return true;
    }
    public boolean check(Map<Character,Integer> mapT,Map<Character,Integer> mapCur){
        for (Character c : mapT.keySet()) {
            if (!mapCur.containsKey(c)){
                return false;
            }
            if (mapCur.get(c)<mapT.get(c)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
