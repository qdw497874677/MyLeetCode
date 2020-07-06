//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找


package com.qdw.leetcode.editor.cn;
//Java：寻找旋转排序数组中的最小值
public class P153FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
//        if (nums.length==1){
//            return nums[0];
//        }
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i-1]){
//                return nums[i];
//            }
//
//        }
//        return nums[0];
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int mid = (r-l)/2+l;
            if (nums[mid]<nums[r]){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
