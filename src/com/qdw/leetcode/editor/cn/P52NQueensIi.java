//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
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
//Java：N皇后 II
public class P52NQueensIi{
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //col[i]表示第i列中是否有皇后
        private boolean[] col;
        private boolean[] dia1;
        private boolean[] dia2;
        int res;
    public int totalNQueens(int n) {
        if (n==0){
            return 0;
        }
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        findQ(n,0);
        return res;
    }
    private void findQ(int n,int curRow){
        if (curRow==n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[curRow+i] && !dia2[curRow-i+n-1]){
                col[i] = true;
                dia1[curRow+i] = true;
                dia2[curRow-i+n-1] = true;
                findQ(n,curRow+1);
                col[i] = false;
                dia1[curRow+i] = false;
                dia2[curRow-i+n-1] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
