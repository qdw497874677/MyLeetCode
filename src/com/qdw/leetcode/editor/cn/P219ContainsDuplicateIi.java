//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.*;

//Java：存在重复元素 II
public class P219ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])){
//                return true;
//            }
//            set.add(nums[i]);
//            if (set.size()>k){
//                set.remove(nums[i-k]);
//            }
//        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (i-map.get(nums[i])<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
