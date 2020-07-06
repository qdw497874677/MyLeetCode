//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：三数之和
public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n<3){
            return res;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            //如果最左边的值比0大，之后的值不可能比0小了，所以直接返回结果。
            if (nums[k]>0){
                return res;
            }
            //跳过重复的值。
            if (k>0 && nums[k]==nums[k-1]){
                continue;
            }
            //k指针后面创建双指针互相靠近。
            i = k+1;
            j = n-1;
            int temp = 0;
            while (i<j){
                temp = nums[i]+nums[j]+nums[k];
                if (temp==0){
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i<j && nums[i+1]==nums[i]){
                        i++;
                    }
                    while (i<j && nums[j-1]==nums[j]){
                        j--;
                    }
                    i++;
                    j--;
                }else if (temp<0){
                    i++;
                }else {
                    j--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
