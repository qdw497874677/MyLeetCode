//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：太平洋大西洋水流问题
public class P417PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new P417PacificAtlanticWaterFlow().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //一个存储能流向太平洋的的坐标
        boolean[][] pa = new boolean[m][n];
        //一个存储能流向大西洋的的坐标
        boolean[][] at = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从海洋开始找
                if (i==0 || j==0){
                    dfs(matrix,i,j,matrix[i][j], pa);
                }
                if (i==m-1 || j==n-1){
                    dfs(matrix,i,j,matrix[i][j],at);
                }
            }
        }
        //一个坐标既能流向太平洋，又能流向大西洋，就是要找的。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pa[i][j] && at[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] matrix,int i,int j,int pre,boolean[][] visited){
        //pre为上一个坐标的高度
        if (i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || visited[i][j] || matrix[i][j] < pre){
            return;
        }
        visited[i][j] = true;
        dfs(matrix,i+1,j,matrix[i][j],visited);
        dfs(matrix,i,j+1,matrix[i][j],visited);
        dfs(matrix,i-1,j,matrix[i][j],visited);
        dfs(matrix,i,j-1,matrix[i][j],visited);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
