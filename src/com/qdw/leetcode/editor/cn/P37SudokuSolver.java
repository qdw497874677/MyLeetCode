//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


package com.qdw.leetcode.editor.cn;
//Java：解数独
public class P37SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] row;
        boolean[][] col;
        boolean[][] block;
    public void solveSudoku(char[][] board) {
        if (board==null){
            return;
        }
        //row[i][num]表示i行存不存在数字num
        row = new boolean[9][9];
        //col[j][num]表示j列存不存在数字num
        col = new boolean[9][9];
        //block[b][num]表示b块存不存在数字num
        block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    //b为9个块的索引，从0到8
                    int b = i/3*3 + j/3;
                    block[b][num] = true;
                }
            }
        }
        find(board,0,0);
    }
    public boolean find(char[][] board,int i,int j){
        //从当前位置向右遍历，直到当前位置为空位，则继续下面的回溯。如果到头也没找到空位，就说明都填完了。
        while (board[i][j]!='.'){
            if (++j>8){
                i++;
                j=0;
            }
            if (i>=9){
                return true;
            }
        }
        //九个数里挑一个
        for (int k = 0; k < 9; k++) {
            int b = i/3*3 + j/3;
            if (!row[i][k] && !col[j][k] && !block[b][k]){
                row[i][k] = true;
                col[j][k] = true;
                block[b][k] = true;
                board[i][j] = (char)('1'+k);
                //从当前位置接着找
                if (find(board,i,j)){
                    return true;
                }else {
                    row[i][k] = false;
                    col[j][k] = false;
                    block[b][k] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
