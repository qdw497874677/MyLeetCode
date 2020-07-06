//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：全排列 II
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        solution.permuteUnique(new int[]{1,1,2});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            List<List<Integer>> res;
            boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        used = new boolean[nums.length];
        find(nums,0,new ArrayList<>());
        return res;
    }
    public void find(int[] nums,int index,List<Integer> list){
        if (index==nums.length){
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        //选择分支的过程中一个值只能选一次
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !set.contains(nums[i])){
                set.add(nums[i]);
                used[i]=true;
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                find(nums,index+1,newList);
                used[i]=false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
