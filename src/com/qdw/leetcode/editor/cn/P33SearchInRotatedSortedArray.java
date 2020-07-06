//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package com.qdw.leetcode.editor.cn;
//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid]==target){
                return mid;
            }
            //中间数在旋转点的右边,不能加=，=说明在左边且左边只有一个数。
            if (nums[mid]<nums[l]){
                //如果目标在中间和右边之间
                if (nums[mid]<target && nums[r]>=target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if (nums[mid]>target && nums[l]<=target){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
