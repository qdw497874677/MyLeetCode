//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n<=0 || k<=0 || k>n){
            return res;
        }
        find(n,k,1,new ArrayList<>());
        return res;
    }
    public void find(int n,int k,int index,List<Integer> list){
        //计较集合中的元素个数是否符合要求
        if (list.size()==k){
            res.add(new ArrayList<>(list));
            System.out.println();
            return;
        }
        //从index开始遍历
        int need = k - list.size();
//        for (int i = index; i <= n; i++) {
        //进行剪枝
        for (int i = index; i <= n-need+1; i++) {
            list.add(i);
            find(n,k,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
