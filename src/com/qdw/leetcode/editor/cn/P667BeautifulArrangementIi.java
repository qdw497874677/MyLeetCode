//给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件： 
//
// ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... 
//, |an-1 - an|] 中应该有且仅有 k 个不同整数；. 
//
// ② 如果存在多种答案，你只需实现并返回其中任意一种. 
//
// 示例 1: 
//
// 
//输入: n = 3, k = 1
//输出: [1, 2, 3]
//解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
// 
//
// 
//
// 示例 2: 
//
// 
//输入: n = 3, k = 2
//输出: [1, 3, 2]
//解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
// 
//
// 
//
// 提示: 
//
// 
// n 和 k 满足条件 1 <= k < n <= 104. 
// 
//
// 
// Related Topics 数组


package com.qdw.leetcode.editor.cn;
//Java：优美的排列 II
public class P667BeautifulArrangementIi{
    public static void main(String[] args) {
        Solution solution = new P667BeautifulArrangementIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArray(int n, int k) {

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1,interval = k; i <= k; i++,interval--) {
            res[i] = i%2==1?res[i-1]+interval:res[i-1]-interval;
        }
        for (int i = k+1; i < n; i++) {
            res[i] = i+1;
        }
        return res;





//        int[] ret = new int[n];
//        ret[0] = 1;
//        //k肯定小于n
//        //interval表示还剩多少个不相同的差值
//        for (int i = 1, interval = k; i <= k; i++, interval--) {
//            //i如果是奇数，第i位置的数值比i-1位置的数据大interval，
//            //i如果是偶数，第i位置的数值比i-1位置的数据小interval，
//            //interval在不断变化，所以前k个相邻差不相同
//            //相当于不断地从递增序列（1到k）的两端取值，放到数组中
//            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
//        }
//        //把剩下的位置补全
//        for (int i = k + 1; i < n; i++) {
//            ret[i] = i + 1;
//        }
//        return ret;

//        //找出前k-1个相邻差值不相等的，剩下的相邻差值相等
//        int[] arr = new int[n];
//        int s = 1, e = n, i = 0;
//        while(s <= e) {
//            //在i不小于k时，i是偶数对应arr数组的值取小的 || 在i大于等于k，第k-1为偶数
//            if((i < k && i % 2 == 0) || (i >= k && (k - 1) % 2 == 0)) {
//                arr[i++] = s++;
//            }
//            else {//在i不小于k时，i是奇数对应arr数组的值取大的
//                arr[i++] = e--;
//            }
//        }
//        return arr;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
