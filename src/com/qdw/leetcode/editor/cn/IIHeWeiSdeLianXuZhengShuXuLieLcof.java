//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
public class IIHeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new IIHeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int[][] arrs = solution.findContinuousSequence(9);
        for(int[] arr:arrs){
            for(int a:arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {

        List<int[]> list = new ArrayList<>();
        int i=1,j=2;
        while (i<=target/2){
            int sum = 0;
            //求i和j之间的和
            for (int k = i; k <= j; k++) {
                sum +=k;
            }
            //如果和小于target，j向右移，更新和
            if (sum<target){
                j++;
                sum += j;
            }else if (sum>target){//如果和大于target，更新和，i向左移
                sum -= i;
                i++;
            }else {
                int[] arr = new int[j-i+1];
                for (int k = i; k <= j; k++) {
                    arr[k-i] = k;

                }
                list.add(arr);
                //左边界接着向右移动
                sum -= i;
                i++;

            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
