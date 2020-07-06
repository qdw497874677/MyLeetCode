//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和
public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        find(candidates,0,0,target,new ArrayList<>());
        return res;
    }
    public void find(int[] candidates,int sum,int index, int target,List<Integer> list){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i]+sum<=target){
                list.add(candidates[i]);
                find(candidates,sum+candidates[i],i,target,list);
                list.remove(list.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
