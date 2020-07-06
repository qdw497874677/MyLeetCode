//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：组合总和 II
public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        //排序，为了之后去重
        Arrays.sort(candidates);
        find(candidates,0,0,target, new ArrayList<>());
        return res;
    }
    public void find(int[] candidates,int sum,int index, int target,List<Integer> list){
        if (sum==target){
            if (!res.contains(list)){
                ArrayList<Integer> newRes = new ArrayList<>(list);
                res.add(newRes);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i]+sum<=target){
                list.add(candidates[i]);
                find(candidates,sum+candidates[i],i+1,target,list);
                list.remove(list.size()-1);
            }else {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
