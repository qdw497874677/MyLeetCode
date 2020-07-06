//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package com.qdw.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)->{
            return a-b;
        });
        for (int num : nums) {
            if (queue.size()==k){
                if(queue.peek()<=num){
                    queue.poll();
                    queue.add(num);
                }
            }else {
                queue.add(num);
            }


//            queue.add(num);
//            if (queue.size()>k){
//                queue.poll();
//            }
        }
//        for (int i = 0; i < k-1; i++) {
//            queue.poll();
//        }
        return queue.poll();
//        return fastGetK(0,nums.length-1,nums,nums.length-k);
    }
    public int fastGetK(int left,int right,int[] nums,int minK){
        if (left == right){
            return nums[left];
        }
        Random random = new Random();
        //我的这个快排 基数只能是第一个，暂时不用随机基数
//        int pivotIndex = left + random.nextInt(right-left);
        int pivotIndex = left;
        pivotIndex = partiton(left,right,pivotIndex,nums);
        if (pivotIndex == minK){
            return nums[pivotIndex];
        }else if (pivotIndex > minK){
            return fastGetK(left,pivotIndex-1,nums,minK);
        }
        return fastGetK(pivotIndex+1,right,nums,minK);
    }
    public int partiton(int left,int right,int pivotIndex,int[] nums){
        int pivot = nums[pivotIndex];
        while (left<right){
            while (left<right && nums[right]>=pivot){
                right--;
            }
            if (left<right){
                nums[left++] = nums[right];
            }
            while (left<right && nums[left]<=pivot){
                left++;
            }
            if (left<right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
