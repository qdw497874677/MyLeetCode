//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：无重叠区间
public class P435NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Queue<Integer> queue = new PriorityQueue<>();
        //贪心算法
        int n = intervals.length;
        if (n == 0){
            return 0;
        }
        //区间右边越小越靠前，若右边相等左边越小越靠前
        Arrays.sort(intervals,(a,b)->{
            return a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0];
        });
        //记录上一个不重叠的区间的索引
        int pre = 0;
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[pre][1]){
                pre = i;
                length++;
            }
        }
        return n - length;




//        int n = intervals.length;
//        if (n==0){
//            return 0;
//        }
//        //对数组排序
//        Arrays.sort(intervals,(a,b)->{
//            return a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1];
//        });
//        int[] dp = new int[n];
//        Arrays.fill(dp,1);
//        int maxL = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (intervals[i][0]>=intervals[j][1]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            maxL = Math.max(maxL,dp[i]);
//        }
//        return n - maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
