//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


package com.qdw.leetcode.editor.cn;

import org.omg.CORBA.INTERNAL;

import java.util.*;

//Java：单词接龙
public class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.add(beginWord);
        queue2.add(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        //用哈希存储单词，方便查找
        Set<String> words = new HashSet<>(wordList);
        int step = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            //比较两个队列，操作短的队列
            if (queue1.size()>queue2.size()){
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> tempV = visited1;
                visited1 = visited2;
                visited2 = tempV;
            }
            step++;
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                String poll = queue1.poll();
                char[] chars = poll.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    //暂存字符
                    char temp = chars[j];
                    //替换字符
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newS = new String(chars);
                        //如果字典中不包含这个单词，跳过
                        if (!words.contains(newS)){
                            continue;
                        }
                        //如果访问就跳过
                        if (visited1.contains(newS)){
                            continue;
                        }
                        //如果另外一个路径包含这个单词，说明相连，返回结果
                        if (visited2.contains(newS)){
                            return step+1;
                        }
                        visited1.add(newS);
                        queue1.add(newS);
                    }
                    chars[j] = temp;
                }
            }
        }
        return 0;
    }
    public boolean canConvert(String s1,String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                count++;
                if (count>1){
                    return false;
                }
            }
        }
        return count == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
