//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：前 K 个高频元素
public class P347TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        //PriorityQueue默认是小顶堆
        Queue<int[]> heap = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for (Integer key : freq.keySet()) {
            Integer f = freq.get(key);
            if (heap.size()<k){
                heap.add(new int[]{key,f});
            }else {
                if (heap.peek()[1]<f){
                    heap.poll();
                    heap.add(new int[]{key,f});
                }
            }
        }
        int size = heap.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
