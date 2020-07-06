//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi{

    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        find(nums,0,new ArrayList<>());
        return res;
    }
    public void find(int[] nums,int index,List<Integer> list){
//        if (!res.contains(list)){
//            res.add(new ArrayList<>(list));
//        }
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            //从这里去重，横向，同一个值只选一次，有重复就跳过。
            if (i>index && nums[i-1]==nums[i]){
                continue;
            }
            list.add(nums[i]);
            //纵向没有影响，可以取重复值。
            find(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
