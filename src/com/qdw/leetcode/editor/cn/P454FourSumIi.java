//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：四数相加 II
public class P454FourSumIi{
    public static void main(String[] args) {
        Solution solution = new P454FourSumIi().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //把所有c和d的组合都存进哈希表
        for (int c : C) {
            for (int d : D) {
                map.put(c + d, map.getOrDefault(c + d, 0) + 1);
            }
        }
        for (int a : A) {
            for (int b : B) {
                if (map.containsKey(-a - b)) {
                    res += map.get(-a - b);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
