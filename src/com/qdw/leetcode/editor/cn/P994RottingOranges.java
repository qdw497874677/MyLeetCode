//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Java：腐烂的橘子
public class P994RottingOranges{
    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(solution.orangesRotting(arr));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        int round=0;//用多少个回合
        int o = 0;//所有橘子
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1 || grid[i][j] == 2){
                    o++;
                    if(grid[i][j] == 2){
                        queue.add(new int[]{i,j});

                    }
                }

            }
        }
        int[] is = new int[2];
        int bad = 0;//变坏的橘子
        while (true){
            int flag = 0;
            int size = queue.size();
            for(int in=0;in<size;in++){

                is= queue.poll();
                bad++;
                int i=is[0];
                int j=is[1];
                if(grid[i][j] == 2){
                    if(i-1>=0){
                        if (grid[i-1][j]==1){
                            grid[i-1][j]=2;
                            queue.add(new int[]{i-1,j});
                            flag++;
                        }
                    }
                    if(i+1<grid.length){
                        if (grid[i+1][j]==1){
                            grid[i+1][j]=2;
                            queue.add(new int[]{i+1,j});
                            flag++;
                        }
                    }
                    if(j-1>=0){
                        if (grid[i][j-1]==1){
                            grid[i][j-1]=2;
                            queue.add(new int[]{i,j-1});
                            flag++;
                        }
//                        grid[i][j-1] = grid[i][j-1]==1?2:grid[i][j-1];
                    }
                    if(j+1<grid[0].length){
                        if (grid[i][j+1]==1){
                            grid[i][j+1]=2;
                            queue.add(new int[]{i,j+1});
                            flag++;
                        }
//                        grid[i][j+1] = grid[i][j+1]==1?2:grid[i][j+1];
                    }
                }
//                queue.poll();
            }
            if (flag != 0){
                round++;
            }else {
                if (bad < o){//如果变坏的数量没有增加，且还有没坏的橘子，表示有橘子坏不了了
                    return -1;
                }
                break;
            }
        }

        return round;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
