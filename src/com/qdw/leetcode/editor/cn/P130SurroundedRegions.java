//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：被围绕的区域
public class P130SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
        char[][] chars = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        solution.solve(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println();
        }
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private boolean[][] visited;
        private int[] dx = {1,-1,0,0};
        private int[] dy = {0,0,1,-1};
        private List<int[]> list;
    public void solve(char[][] board) {
        if (board==null){
            return;
        }
        int m = board.length;
        if (m==0){
            return;
        }
        int n = board[0].length;
        if (m==0 || n==0){
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='Y'){
                    board[i][j]='O';
                }else if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

//        visited = new boolean[m][n];
//        list = new ArrayList<>();
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (!visited[i][j] && board[i][j]=='O'){
//                    if (helper(board,i,j)){
//                        for (int[] ints : list) {
//                            board[ints[0]][ints[1]] = 'X';
//                        }
//                    }else {
//                        for (int[] ints : list) {
//                            visited[ints[0]][ints[1]] = false;
//                        }
//                        list.clear();
//                    }
//                }
//            }
//        }
    }
    public void dfs(char[][] board,int i,int j){
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='Y'){
            return;
        }
        board[i][j] = 'Y';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);

    }
    public boolean helper(char[][] board,int i,int j){
        if (i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if (board[i][j]=='X' || visited[i][j]){
            return true;
        }
        visited[i][j] = true;
        list.add(new int[]{i,j});
        boolean res = true;
        for (int k = 0; k < 4; k++) {
            res = res && helper(board,i+dx[k],j+dy[k]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//        ,["O","O","O","O","X","X"]
//        ,["O","O","O","O","O","O"]
//        ,["O","X","O","X","O","O"]
//        ,["O","X","O","O","X","O"]
//        ,["O","X","O","X","O","O"]
//        ,["O","X","O","O","O","O"]
//
//                [["O","O","O","O","X","X"]
//                ,["O","O","O","O","O","O"]
//                ,["O","X","O","X","O","O"]
//                ,["O","X","O","X","X","O"]
//                ,["O","X","O","X","O","O"]
//                ,["O","X","O","O","O","O"]]
//
//                ["O","O","O","O","X","X"]
//                ,["O","O","O","O","O","O"]
//                ,["O","X","O","X","O","O"]
//                ,["O","X","O","O","X","O"]
//                ,["O","X","O","X","O","O"]
//                ,["O","X","O","O","O","O"]
}
