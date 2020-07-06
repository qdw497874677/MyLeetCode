//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


package com.qdw.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：完全平方数
public class P279PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
//        int[] dp = new int[n+1];
//        for (int i = 0; i <=n; i++) {
//            dp[i] = i;
//            for (int j = 0; j*j<=i; j++) {
//                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
//            }
//        }
//        return dp[n];

        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j*j <= i; j++) {
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];


        //队列的元素为一个数组，第二个位置为n到第一个数字的最短距离
//        Queue<int[]> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n+1];
//        visited[n] = true;
//        queue.add(new int[]{n,0});
//        while (!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int num = poll[0];
//            int step = poll[1];
//            if (num == 0){
//                return step;
//            }
//            //对于所有中间可能存在的完全平方数，且没有访问过得，都加入队列，并且step+1
//            for(int i=1;;i++){
//                int a = num-i*i;
//                if(a<0){
//                    break;
//                }
//                if(a==0){
//                    return step+1;
//                }
//                if(!visited[a]){
//                    visited[a] = true;
//                    queue.add(new int[]{a,step+1});
//                }
//            }
//        }
//        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
