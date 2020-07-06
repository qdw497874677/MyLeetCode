//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：单词规律
public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] sA = str.split(" ");
        if (sA.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = map.get(c);
            //如果没有key
            if (s==null){
                s = sA[i];
                //没有key，但是存在这个value，返回false
                if (map.containsValue(s)){
                    return false;
                }
                map.put(c,s);
            }else {
                //如果存在相同的key，但是和这个key的value不一致，返回false
                if (!s.equals(sA[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
