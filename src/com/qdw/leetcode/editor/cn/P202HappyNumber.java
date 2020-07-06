//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学


package com.qdw.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：快乐数
public class P202HappyNumber{
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = 0;
            while (n!=0){
                int a = n%10;
                sum += a*a;
                n = n/10;
            }
            if (!set.contains(sum)){
                set.add(sum);
            }else {
                return false;
            }
            n = sum;
            if (sum == 1){
                return true;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
