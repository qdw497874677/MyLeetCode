//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


package com.qdw.leetcode.editor.cn;

import java.util.Map;

//Java：数组中的逆序对
public class P51ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        Solution solution = new P51ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(solution.reversePairs(nums));
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        return mergeSort(nums,0,nums.length-1,temp);
    }
    public int mergeSort(int[] nums,int left,int right,int[] temp){
        if(left==right){
            return 0;
        }
        int mid = left + (right-left)/2;
        int leftCount = mergeSort(nums,left,mid,temp);
        int rightCount = mergeSort(nums,mid+1,right,temp);
        if (nums[mid] <= nums[mid+1]){
            System.out.println("!");
            return leftCount + rightCount;
        }
        int crossCount = merge(nums,left,mid,right,temp);
        return leftCount + crossCount + rightCount;
    }
    public int merge(int[] nums,int left,int mid,int right,int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid+1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i==mid+1){
                nums[k] = temp[j++];
            }else if (j==right+1){
                nums[k] = temp[i++];
            }else if (temp[i]<=temp[j]){
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                //每当右数组的数放进新数组中，把此时还没有放进新数组的左数组的元素个数加进计数器
                count += (mid-i+1);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
