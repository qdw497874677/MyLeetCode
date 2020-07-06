//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package com.qdw.leetcode.editor.cn;
//Java：寻找两个有序数组的中位数
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            //right表示当前i所在的最新的值，left表示上一个值
            left = right;
            //start1为nums1的指针，start2为nums2的指针
            //如果start1没有越界且start1所在的值比start2所在的值大。或者start1没有越界且start2已经越界了。
            //此时应该选start1所在的值，start1++
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        //如果有偶数个元素就把中间的两个数相加除二
        if ((len & 1) == 0){
            return (left + right) / 2.0;
        }else {
            //如果有奇数个，right的值就是中位数的值
            return right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
