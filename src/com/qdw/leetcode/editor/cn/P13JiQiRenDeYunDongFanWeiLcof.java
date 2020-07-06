//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 1： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//


package com.qdw.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：机器人的运动范围
public class P13JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new P13JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
        System.out.println(solution.movingCount(3, 2, 17));
//        System.out.println(solution.isOk(2, 12, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] arr = new boolean[m][n];

//        return dfs(0,0,m,n,k,arr);
        queue.add(new int[]{0,0});

        while (queue.size()!=0){
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            if (a<0||b<0||a>=m||b>=n||!isOk(a,b,k)||arr[a][b]){
                continue;
            }
            res++;
            arr[a][b] = true;
            queue.add(new int[]{a-1,b});
            queue.add(new int[]{a,b-1});
            queue.add(new int[]{a+1,b});
            queue.add(new int[]{a,b+1});
        }
        return res;
    }
    public int dfs(int i,int j,int m,int n,int k,boolean[][] arr){
        if (i<0||j<0||i>=m||j>=n||!isOk(i,j,k)||arr[i][j]){
            return 0;
        }
        arr[i][j] = true;
        return dfs(i-1,j,m,n,k,arr)
                +dfs(i+1,j,m,n,k,arr)
                +dfs(i,j-1,m,n,k,arr)
                +dfs(i,j+1,m,n,k,arr)
                +1;

    }

    public boolean isOk(int i,int j,int k){
        int res = 0;
        String s1 = String.valueOf(i);
        String s2 = String.valueOf(j);
        for (int l = 0; l < s1.length(); l++) {
            res += s1.charAt(l)-'0';
        }
        for (int l = 0; l < s2.length(); l++) {
            res += s2.charAt(l)-'0';
        }
        return k>=res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
