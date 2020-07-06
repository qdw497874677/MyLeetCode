//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package com.qdw.leetcode.editor.cn;
//Java：岛屿数量
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        int res = 0;
        int r = grid.length;
        int l = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (dfs(grid,i,j)>0){
                    res++;
                }
            }
        }
        return res;
    }
    public int dfs(char[][] grid,int i,int j){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return 0;
        }
        int sum = 1;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid,i+dx[k],j+dy[k]);
        }
        return sum;
    }






//    public int dfs(char[][] grid,int i,int j){
//        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
//            return 0;
//        }
//        grid[i][j]='0';
//        int res = 1;
//        res += dfs(grid,i-1,j);
//        res += dfs(grid,i+1,j);
//        res += dfs(grid,i,j-1);
//        res += dfs(grid,i,j+1);
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
