//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：和为K的子数组
public class P560SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        //用map记录当前子数组之和的频率
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            pre += num;
            Integer integer = map.get(pre - k);
            if (integer != null) {
                count += integer;
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
