//给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的
//差的绝对值最大为 ķ。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map


package com.qdw.leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;

//Java：存在重复元素 III
public class P220ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new P220ContainsDuplicateIii().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 返回Set中小于/等于e的最大元素。
            Integer f = set.floor(nums[i]);
            //为了防止越界，把t加到左边来。
            if (f!=null && f+t>=nums[i]){
                return true;
            }
            // 返回Set中大于/等于e的最小元素。
            Integer c = set.ceiling(nums[i]);
            if (c!=null && c<=nums[i]+t){
                return true;
            }
            set.add(nums[i]);
            //元素个数超过了，就把最前面的元素删除。
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
