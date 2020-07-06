//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。 
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。 
//
// 注意：每次拼写时，chars 中的每个字母都只能用一次。 
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// 所有字符串中都仅包含小写英文字母 
// 
// Related Topics 数组 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：拼写单词
public class P1160FindWordsThatCanBeFormedByCharacters{
    public static void main(String[] args) {
        Solution solution = new P1160FindWordsThatCanBeFormedByCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        //统计字母表中字母的出现次数
        int[] charsCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charsCount[chars.charAt(i)-'a']++;
        }
        for (String word : words) {
            //统计单词中字母出现次数
            int[] wordCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                wordCount[word.charAt(i)-'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (charsCount[i] < wordCount[i]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res += word.length();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}