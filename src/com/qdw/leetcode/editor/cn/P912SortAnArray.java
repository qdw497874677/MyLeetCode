//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
//


package com.qdw.leetcode.editor.cn;
//Java：排序数组
public class P912SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        fast(nums,0,nums.length-1);
        return nums;
    }
    public void fast(int[] arr,int left,int right){
        if (left<right){
            int index = part(arr,left,right);
            fast(arr,left,index-1);
            fast(arr,index+1,right);
        }
    }
    public int part(int[] arr,int left,int right){
        int index = arr[left];
        while (left<right){
            while (left<right && arr[right] >= index){
                right--;
            }
            if (left<right){
                arr[left++] = arr[right];
            }
            while (left<right && arr[left] <= index){
                left++;
            }
            if (left<right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = index;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
