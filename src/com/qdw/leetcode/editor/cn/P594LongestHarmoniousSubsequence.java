//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;

//Java：最长和谐子序列
public class P594LongestHarmoniousSubsequence{
    public static void main(String[] args) {
        Solution solution = new P594LongestHarmoniousSubsequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        //键存数组中的数值，值存数值出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int longest = 0;
        //找出map中num和num+1的出现次数之和最大 有多大
        for(int num:nums){
            //防止越界，num+1不存在，说明num是最后一个键
            if(map.containsKey(num+1)){
                longest = Math.max(longest,map.get(num)+map.get(num+1));
            }

        }
        return longest;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
