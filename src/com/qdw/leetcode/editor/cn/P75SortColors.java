//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针


package com.qdw.leetcode.editor.cn;
//Java：颜色分类
public class P75SortColors{
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        for (int i = 0; i <= right;) {
            //如果当前指针是0，就和左指针交换，两个指针都右移
            //因为每次循环要比较的都要求是新的值，所以和左边交换后，当前指针不用右移；
            // 而和右边交换后，就不用右移，因为右边交换来的值也是新的值
            if (nums[i] == 0){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            }else if(nums[i] == 2){
                //如果当前指针是2，就和右指针交换，右指针左移
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }else {
                //如果当前指针是中间的1，就不变，当前指针右移
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
