//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 
//请注意，它是排序后的第k小元素，而不是第k个元素。 
//
// 示例: 
//
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 说明: 
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


package com.qdw.leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：有序矩阵中第K小的元素
public class P378KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        int[][] m = {{1,3},{2,5}};

        System.out.println(solution.kthSmallest(m,3));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[r-1][c-1];

        while (low<high){
            int mid = (high-low)/2 + low;
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c && matrix[i][j]<=mid; j++) {
                    count++;
                }
            }
            if (count<k){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;




//        int x = matrix.length;
//        int y = matrix[0].length;
//        PriorityQueue<int[]> queue = new PriorityQueue<>((v1,v2)->v1[2]-v2[2]);//小堆
//        for(int j = 0; j < y; j++) {
//            queue.offer(new int[]{0, j, matrix[0][j]});
//        }
//        int[] v = new int[]{0, 0, -1};
//        while(!queue.isEmpty() && k > 0){
//            k--;
//            v = queue.poll();
//            if(v[0] + 1 < x)
//            {
//                queue.offer(new int[]{v[0]+1, v[1], matrix[v[0]+1][v[1]]});
//            }
//        }
//        return v[2];

        //二分查找
//        int r = matrix.length;
//        int c = matrix[0].length;
//        int low = matrix[0][0];//最小值
//        int high = matrix[r-1][c-1];//最大值
//        while (low<=high){
//            //取中间值
//            int mid = (high-low)/2+low;
//            int count=0;
//            //算出小于等于中间值的有多少个数
//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c && matrix[i][j]<=mid; j++) {
//                    count++;
//                }
//
//            }
//            //如果比k小，说明第k小在右边
//            if (count<k){
//                low = mid+1;
//            }else {//如果比k大，说明第k小在左边
//                high = mid-1;//为什么是mid-1，还在想,
//                // 因为假如第k小数是此时的mid，
//                // 那么下次，新的mid就是上次的high，
//                // 那么low就是mid+1，也就是上次的mid
//                //如果此时high=mid,那么循环条件就不存在low等于high
//
//            }
//        }
//        return low;


        //1 3
        //2 5
        //l=1 h=5 mid=3
        //l=1 h=3-1=2 mid=2
        //l=2+1=3 h=2

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
