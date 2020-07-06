//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < n; i++) {
            int l = i+1;
            int r = n-1;
            int temp = 0;
            while (l<r){
                temp = nums[i] + nums[l] + nums[r];
                if (temp==target){
                    //如果等于target，就是最近的了，直接返回结果。
                    return temp;
                }
                if (Math.abs(temp-target)<Math.abs(res-target)){
                    res = temp;
                }else if (temp>target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
