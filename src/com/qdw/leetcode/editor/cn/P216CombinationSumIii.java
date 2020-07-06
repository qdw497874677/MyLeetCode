//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 III
public class P216CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if (k==0 || n==0){
            return res;
        }
        find(k,n,0,1,0,new ArrayList<>());
        return res;
    }
    private void find(int k, int n,int sum, int index,int size, ArrayList<Integer> list) {
        //用一个变量size记录元素个数，比调用size()快
        if (size==k){
            if (sum==n){
                res.add(new ArrayList<>(list));
                return;
            }else {
                return;
            }
        }
        for (int i = index; i <= 9; i++) {
            if (sum+i<=n){
                list.add(i);
                find(k,n,sum+i,i+1,size+1,list);
                list.remove(list.size()-1);
            }else {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
