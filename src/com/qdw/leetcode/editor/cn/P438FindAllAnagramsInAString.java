//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if(s == null || s.length() == 0){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
            int[] needs = new int[26];
            int[] window = new int[26];
            //用total检测窗口中是否已经涵盖了p中的字符
            int left = 0, right = 0, total = p.length();
            //把p的所有字符放到need数组中
            for(char ch : p.toCharArray()){
                needs[ch - 'a'] ++;
            }
            while(right < s.length()){
                //右指针的字符
                char chr = s.charAt(right);
                if(needs[chr - 'a'] > 0){
                    window[chr - 'a'] ++;
                    if(window[chr - 'a'] <= needs[chr - 'a']){
                        total --;
                    }
                }
                //当计数为0时
                while(total == 0){
                    if(right-left+1 == p.length()){
                        res.add(left);
                    }
                    char chl = s.charAt(left);
                    //如果need中存在，左指针的值
                    if(needs[chl - 'a'] > 0){
                        window[chl - 'a'] --;
                        if(window[chl - 'a'] < needs[chl - 'a']){
                            total ++;
                        }
                    }
                    left ++;
                }
                right ++;
            }
            return res;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
