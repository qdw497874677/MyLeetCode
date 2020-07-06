//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：数组的度
public class P697DegreeOfAnArray{
    public static void main(String[] args) {
        Solution solution = new P697DegreeOfAnArray().new Solution();
        int a = solution.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println(a);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        //map键是出现的值，值为一个数组分别表示，第一次出现的位置，最新出现的位置和出现的次数
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int[] arr = map.get(nums[i]);
                arr[1] = i;
                arr[2]++;
                map.put(nums[i],arr);
            }else {
                map.put(nums[i],new int[]{i,i,1});
            }
        }
        int max = 0;
        int s = Integer.MAX_VALUE;
        for(int i:map.keySet()){
            int a = map.get(i)[2];
            int b = (map.get(i)[1]-map.get(i)[0]+1);
            if(a > max){
                max = a;
                s = b;
            }else if (a == max && b<s){
                s = b;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
