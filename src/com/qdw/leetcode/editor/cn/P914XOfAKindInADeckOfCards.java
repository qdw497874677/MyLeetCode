//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 3： 
//
// 输入：[1]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 4： 
//
// 输入：[1,1]
//输出：true
//解释：可行的分组是 [1,1]
// 
//
// 示例 5： 
//
// 输入：[1,1,2,2,2,2]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[2,2]
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10000 
// 0 <= deck[i] < 10000 
// 
//
// 
// Related Topics 数组 数学


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：卡牌分组
public class P914XOfAKindInADeckOfCards{
    public static void main(String[] args) {
        Solution solution = new P914XOfAKindInADeckOfCards().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length==1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
//        int min = Integer.MAX_VALUE;
        int i = 0;
        for (Integer integer : map.keySet()) {
            if (i==0){
                i = map.get(integer);
                continue;
            }
            int now = map.get(integer);
            int a = gcd(i,now);
            if (a <= 1){
                return false;
            }
//            min = Math.min(min,a);
            i = now;
        }
        return true;
    }
    public int gcd(int num1, int num2) {
        // 利用辗转相除法来计算最大公约数
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
