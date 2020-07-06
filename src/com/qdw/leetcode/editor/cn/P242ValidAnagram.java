//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;

//Java：有效的字母异位词
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram","nagaram"));
        System.out.println(solution.isAnagram("a","b"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(char c:s.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        for(char c:t.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)-1);
//        }
//
//        for(char c:map.keySet()){
//            if(map.get(c) != 0){
//                return false;
//            }
//        }
//        return true;

        //因为一共就26个字母，所以用数组代替HashMap存储每个字母出现的个数
        int[] cnts = new int[26];
        //s每有一个字符，就会再数组的相应位置+1
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        //t每有一个字符，就会再数组的相应位置-1
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        //如果数组有不为零的说明，s和t不是字母异位词
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
