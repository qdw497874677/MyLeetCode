//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
// A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 50000 
// -10^4 <= A[i] <= 10^4 
// 
// Related Topics 数组


package com.qdw.leetcode.editor.cn;
//Java：将数组分成和相等的三个部分
public class P1013PartitionArrayIntoThreePartsWithEqualSum{
    public static void main(String[] args) {
        Solution solution = new P1013PartitionArrayIntoThreePartsWithEqualSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        //暴力
//        int sum = 0;
//        for (int i : A) {
//            sum += i;
//        }
//        int isum=0;
//        for (int i = 0; i < A.length-2; i++) {
//            isum += A[i];
//            int jsum=0;
//            for (int j = i+1; j < A.length - 1; j++) {
//                jsum += A[j];
//                if (isum == jsum){
//                    if(isum == sum-isum-jsum){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;

        //双指针
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum%3!=0){
            return false;
        }
        int i=0;
        int j=A.length-1;
        int isum=A[i];
        int jsum=A[j];
        while (i+1<j) {
            if (isum == sum/3 && jsum == sum/3){
                return true;
            }
            if (isum != sum/3){
                i++;
                isum += A[i];
            }else
            if (jsum != sum/3){
                j--;
                jsum += A[j];
            }

        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
