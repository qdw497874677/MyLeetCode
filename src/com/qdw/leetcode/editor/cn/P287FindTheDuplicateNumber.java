//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找


package com.qdw.leetcode.editor.cn;
//Java：寻找重复数
public class P287FindTheDuplicateNumber{
    public static void main(String[] args) {
        Solution solution = new P287FindTheDuplicateNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
//        int[] count = new int[nums.length];
////        for (int i = 0; i < nums.length; i++) {
////            count[nums[i]-1]++;
////            if (count[nums[i]-1] == 2){
////                return nums[i];
////            }
////        }
////        return 0;


        int l = 0;
        int h = nums.length;
        while (l<=h){
            int min = (h+l)/2;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<=min){
                    count++;
                }
            }
            if (count>min){
                h = min-1;
            }else {
                l = min+1;
            }
        }
        return l;







//        int l = 1, h = nums.length - 1;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            int cnt = 0;
//            //统计中数之前的元素数量，如果大于中数，说明前面的元素比正常的多，重复的数在前面
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//            if (cnt > mid) {
//                h = mid - 1;
//            }
//            else {
//                l = mid + 1;
//            }
//        }
//        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
