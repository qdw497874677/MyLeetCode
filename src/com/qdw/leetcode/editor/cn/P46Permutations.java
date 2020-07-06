//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res;
        boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        find(nums,0,list);
        return res;
    }
    public void find(int[] nums,int index,List<Integer> list){
        if (index == nums.length){
            res.add(new ArrayList<>(list));
//            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果当前线路中，用过这个数，这个线之后就不能用了
            if (!used[i]){
                used[i] = true;
                list.add(nums[i]);
//                List<Integer> newList = new ArrayList<>(list);
//                newList.add(nums[i]);
                find(nums,index+1,list);
//                find(nums,index+1,newList);
                //回溯回来后，记得把对修改的复原，为了下一条路
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
