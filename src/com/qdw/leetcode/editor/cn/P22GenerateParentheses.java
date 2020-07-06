//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res,"",0,0,n);
        return res;
    }
    public void dfs(List res,String str,int count1,int count2,int n){
        if (count1>n || count2>n || count1<count2){
            return;
        }
        if (count1==n && count2==n){
            res.add(str);
        }
        if (count1>=count2){
            String newStr = new String(str);
            dfs(res,str+"(",count1+1,count2,n);
            dfs(res,newStr+")",count1,count2+1,n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
