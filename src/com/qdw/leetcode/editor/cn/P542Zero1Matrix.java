//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


package com.qdw.leetcode.editor.cn;
//Java：01 矩阵
public class P542Zero1Matrix{
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        //正想遍历，当前的值和上和左对比
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j]==1){
                    matrix[i][j] = r+c;
                }
                if (i>0){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i-1][j]+1);
                }
                if (j>0){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][j-1]+1);
                }
            }
        }
        for (int i = r-1; i >= 0; i--) {
            for (int j = c-1; j >= 0; j--) {
                if (i<r-1){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i+1][j]+1);
                }
                if (j<c-1){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][j+1]+1);
                }
            }
        }
        return matrix;
    }
//    public int dfs(int[][] matrix,int m,int n){
//        if (m>=matrix.length || n>=matrix[0].length || m<0 || n<0){
//            return 0;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
