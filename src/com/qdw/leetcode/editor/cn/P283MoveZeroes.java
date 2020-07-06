//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


package com.qdw.leetcode.editor.cn;
//Java：移动零
public class P283MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        int[] a = new int[]{1,3,4,0,6,7};
        solution.moveZeroes(a);
        for(int i:a){
            System.out.println(i);
        }
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //j表示非零的位置
        int j = 0;
        //遍历所有数
        for (int i = 0; i < nums.length; i++) {
            //如果不是零，i的数放到j上
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
            //是零就过
        }
        //j以后的都是零
        for (int i = j; i < nums.length ; i++) {
            nums[i] = 0;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
