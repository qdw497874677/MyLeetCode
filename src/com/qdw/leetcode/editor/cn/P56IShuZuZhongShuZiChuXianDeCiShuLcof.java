//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums <= 10000 
// 
//
// 
//


package com.qdw.leetcode.editor.cn;
//Java：数组中数字出现的次数
public class P56IShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P56IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int i = 0;
        //得到的i就是两个不相等的数的亦或结果，因为其他都是成对的亦或后归零
        for (int num : nums) {
            i = i^num;
        }
        int j = 1;
        //找到i中那个不为0的一位
        //通过二进制1、10、100等去和i做与运算。当i&j为1说明，i的这位为1（1&0=0、1&1=1）。
        // 这位为1说明这两个不同的数中，其中一个的这位为0，另一个的这位为1。这样这两位亦或^才会是1.
        while ((i&j)==0){
            j = j<<1;
        }
        int a = 0;
        int b = 0;
        //这两个不同的数分别在num & j为0和num & j为1这两组数中，这样就把这两组数差分开。
        //两组分别自我做亦或，各得到一个没有成对的数。
        for (int num : nums) {
            if((num & j) == 0){
                a = a^num;
            }else {
                b = b^num;
            }
        }
        return new int[]{a,b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
