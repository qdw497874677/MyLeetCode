//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
        int[][] a = new int[][]{{1,4},{0,5}};
        solution.merge(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<2){
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if ((intervals[i][0]>=intervals[j][0] && intervals[i][0]<=intervals[j][1]) ||
                    (intervals[i][1]>=intervals[j][0] && intervals[i][1]<=intervals[j][1])){
                intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                intervals[j][1] = Math.max(intervals[i][1],intervals[j][1]);
            }else {
                list.add(new int[]{intervals[j][0],intervals[j][1]});
                j++;
                intervals[j][0] = intervals[i][0];
                intervals[j][1] = intervals[i][1];
            }
        }
        list.add(new int[]{intervals[j][0],intervals[j][1]});
        int[][] res = list.toArray(new int[list.size()][2]);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
