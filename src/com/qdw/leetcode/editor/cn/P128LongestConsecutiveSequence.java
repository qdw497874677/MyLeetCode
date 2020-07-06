//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：最长连续序列
public class P128LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        // 每次只从找右边的，如果左边不存在再找右边。
        // 如果存在就说明已经找过了，少了左边的肯定不会更长，所以就不找了。
        for (int num : nums) {
            if (!set.contains(num-1)){
                int curNum = num;
                int curRes = 1;
                // 找右边是否有相邻的数
                while (set.contains(curNum+1)){
                    curNum++;
                    curRes++;
                }
                res = Math.max(curRes,res);
            }
        }
        return res;



//        HashSet<Integer> set = new HashSet<>();
//        for(int num:nums){
//            set.add(num);
//        }
//        int longest = 0;
//        for(int num:nums){
//            int cur_length = 1;
//            int i = num;
//            //依次比num小1分数，如果没有了就停
//            while (set.remove(i-1)){
//                cur_length++;
//                i--;
//            }
//            i = num;
//            //依次比num大1分数，如果没有了就停
//            while (set.remove(i+1)){
//                cur_length++;
//                i++;
//            }
//            //比较找出最长的长度
//            longest = Math.max(longest,cur_length);
//        }
//        return longest;

//        Map<Integer, Integer> countForNum = new HashMap<>();
//        for (int num : nums) {
//            countForNum.put(num, 1);
//        }
//        for (int num : nums) {
//            forward(countForNum, num);
//        }
//        return maxCount(countForNum);
    }

        private int forward(Map<Integer, Integer> countForNum, int num) {
            if (!countForNum.containsKey(num)) {
                return 0;
            }
            int cnt = countForNum.get(num);
            if (cnt > 1) {
                return cnt;
            }
            cnt = forward(countForNum, num + 1) + 1;
            countForNum.put(num, cnt);
            return cnt;
        }

        private int maxCount(Map<Integer, Integer> countForNum) {
            int max = 0;
            for (int num : countForNum.keySet()) {
                max = Math.max(max, countForNum.get(num));
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
