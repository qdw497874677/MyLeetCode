//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：N皇后
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n==0){
            return res;
        }
        col = new boolean[n];
        dia1 = new boolean[n*2-1];
        dia2 = new boolean[n*2-1];
        findQueens(n,0,new ArrayList<>());
        return res;
    }
    public void findQueens(int n,int index,List<Integer> row){
        if (index == n){
            List<String> list = new ArrayList<>();
            for (Integer integer : row) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i!=integer){
                        sb.append(".");
                    }else {
                        sb.append("Q");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        //i表示列
        for (int i = 0; i < n; i++) {
            //col表示当前列是否有皇后
            //dia1表示当前斜列右上到左下是否有皇后
            //dia2表示当前斜列左上到右下是否有皇后
            if (!col[i] && !dia1[i+index] && !dia2[index-i+n-1]){
                col[i]=true;
                dia1[i+index]=true;
                dia2[index-i+n-1]=true;
                row.add(i);
                findQueens(n,index+1,row);
                row.remove(row.size()-1);
                col[i]=false;
                dia1[i+index]=false;
                dia2[index-i+n-1]=false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
