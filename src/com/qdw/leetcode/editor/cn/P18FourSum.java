//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum{
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n<4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //三数之和
            for (int j = i+1; j < n; j++) {
                if (j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = n-1;
                int temp = 0;
                while (l<r){
                    temp = nums[i]+nums[j]+nums[l]+nums[r];
                    if (temp==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                        while (l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                    }else if (temp>target){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
