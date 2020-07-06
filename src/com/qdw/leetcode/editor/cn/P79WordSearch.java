//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package com.qdw.leetcode.editor.cn;
//Java：单词搜索
public class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        private boolean[][] visited;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
//        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrack(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board, String word,int i,int j,int index){
        if (index == word.length()-1){
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)){
//            visited[i][j] = true;
            char temp = board[i][j];
            board[i][j] = '?';
            for (int k = 0; k < 4; k++) {
                int newI = i+dx[k];
                int newJ = j+dy[k];
//                if ( newI<0 || newJ<0 || newI>board.length-1 || newJ>board[0].length-1 || visited[newI][newJ]){
                if ( newI<0 || newJ<0 || newI>board.length-1 || newJ>board[0].length-1 || board[i][j]!='?'){
                    continue;
                }
                if (backTrack(board,word,newI,newJ,index+1)){
                    return true;
                }
            }
//            visited[i][j] = false;
            board[i][j] = temp;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
