//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res;
        String[] letterMap = {
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length()==0){
            return res;
        }
        find(digits,0,"");
        return res;
    }
    //s表示i之前的数字转化为字符转的一个结果
    public void find(String digits,int i,String s){
        //如果i是末尾了，就把这个结果加进去
        if (i==digits.length()){
            res.add(s);
            return;
        }
        //通过字母数组去除数字对应的字符串，将他们一个一个加入到结果中，然后递归
        int cur = digits.charAt(i)-'0';
        for (int j = 0; j < letterMap[cur].length(); j++) {
            find(digits,i+1,s+letterMap[cur].charAt(j));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
