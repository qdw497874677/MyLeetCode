//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：字母异位词分组
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.get(s);
            if (list==null){
                list = new ArrayList<>();
                map.put(s,list);
            }
            list.add(str);
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
