//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。 
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组： 
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。 
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。 
//
// 
//
// 示例: 
//
// 
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
// 
// Related Topics 数学 动态规划


package com.qdw.leetcode.editor.cn;
//Java：等差数列划分
public class P413ArithmeticSlices{
    public static void main(String[] args) {
        Solution solution = new P413ArithmeticSlices().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length<3){
            return 0;
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < A.length-1; i++) {
            //数组i的值表示，A[i+1]-A[i]的值
            //重新计算i的值后，如果两个以上的值相等，说明存在连续的等差数列
            A[i] = A[i+1] - A[i];
            if (i>=1){
                //计算出现连续等差的次数，如果A[i] == A[i-1]，表示原始的A[i-1],A[i],A[i+1]等差
                if (A[i] == A[i-1]){
                    count++;
                }else {
                    count = 0;
                }
            }
            //count=1 说明3或3个以上的连续数之间差值相等了
            //有三个相连的就会有1个等差数列，四个相连的就会有1+2个等差数列
            //所以count相加就是所有相连等差数列
            if (count>=1){
                res += count;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
