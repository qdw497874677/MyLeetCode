//给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。 
//
// 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
// 2, 5]。 
//
// 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。 
//
// 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？ 
//
// 
//
// 示例： 
//
// 输入: words = ["time", "me", "bell"]
//输出: 10
//说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// 每个单词都是小写字母 。 
// 
//


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词的压缩编码
public class P820ShortEncodingOfWords{
    public static void main(String[] args) {
        Solution solution = new P820ShortEncodingOfWords().new Solution();
        String[] s = {"qdw","dw"};
        int i = solution.minimumLengthEncoding(s);
        System.out.println(i);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                set.remove(word.substring(k));
            }
        }
        int ans = 0;
        for (String word : set){
            ans += word.length() + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
