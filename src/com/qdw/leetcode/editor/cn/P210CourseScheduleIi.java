//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：课程表 II
public class P210CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses==0){
            return new int[]{0};
        }
        //统计每个课程的入度。
        int[] inDegrees = new int[numCourses];
        //把一个课程下一步可以学的都放在一个列表中。
        List<Integer>[] lists = new ArrayList[numCourses];
        for (int[] p : prerequisites) {
            if (lists[p[1]]==null){
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的课程加入队列。
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i]==0){
                queue.add(i);
            }
        }
        //记录已经学习的课程数。
        int count = 0;
        int[] res = new int[numCourses];
        //当一门课程的入度为0的时候就可以进行学习了。
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            res[count++] = poll;
            if (lists[poll]==null){
                continue;
            }
            //对于当前课程能访问的课程中，把他们的入度减掉。
            for (Integer integer : lists[poll]) {
                inDegrees[integer]--;
                //如果入度为零就说明学完了前驱课程就可以准备学了，加入队列。
                if (inDegrees[integer]==0){
                    queue.add(integer);
                }
            }
        }
        if (count==numCourses){
            return res;
        }
        return new int[0];


//        if (numCourses==0){
//            return new int[]{0};
//        }
//        int[] status = new int[numCourses];
//        int[][] graph = new int[numCourses][numCourses];
//        for (int[] p : prerequisites) {
//            //学p[0]前，先学p[1]
//            graph[p[1]][p[0]] = 1;
//        }
//        Deque<Integer> stack = new LinkedList<>();
//        //从每个课开始深度遍历，找前驱课程。
//        for (int i = 0; i < numCourses; i++) {
//            //如果有环，就直接返回空结果。
//            if (!dfs(status,graph,i,stack)){
//                return new int[0];
//            }
//        }
//        int[] res = new int[stack.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = stack.pollFirst();
//        }
//        return res;
    }
    public boolean dfs(int[] status, int[][] graph, int i, Deque<Integer> stack){
        if(status[i]==1){
            return false;
        }else if(status[i]==2){
            return true;
        }
        status[i] = 1;
        //在课程表中找前驱课程。
        for (int j = 0; j < graph.length; j++) {
            //如果能连接，并且访问到了正在访问的节点，说明有环。有环就直接返回false。
            if (graph[i][j]==1 && !dfs(status,graph,j,stack)){
                return false;
            }
        }
        status[i] = 2;
        stack.addFirst(i);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
