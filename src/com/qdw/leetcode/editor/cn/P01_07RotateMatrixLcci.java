//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组


package com.qdw.leetcode.editor.cn;
//Java：旋转矩阵
public class P01_07RotateMatrixLcci{
    public static void main(String[] args) {
        Solution solution = new P01_07RotateMatrixLcci().new Solution();
        int[][] m = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.rotate(m);
        for (int i = 0; i < m.length; i++) {
            System.out.println();
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+" ");
            }
        }
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
