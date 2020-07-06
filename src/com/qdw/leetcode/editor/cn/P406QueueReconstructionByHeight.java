//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：根据身高重建队列
public class P406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new P406QueueReconstructionByHeight().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //根据k升序。
        Arrays.sort(people,(a,b)->{
            return a[1]-b[1];
        });
        //再根据h降序。
        Arrays.sort(people,(a,b)->{
            return b[0]-a[0];
        });
        for (int[] person : people) {
            System.out.println(person[0] +" "+ person[1]);
        }
        List<int[]> list = new LinkedList<>();
        //按照循序插入集合的k位置，再转化为数组。
        // k相等数组h大的在前面，所以插入集合后，k位置优先放矮的，因为他们在数组的靠后位置。
        // 而对于挤到后面的高的，前面有矮的并不影响他们。
        System.out.println();
        for (int[] person : people) {
            System.out.println(person[1]+"_"+person[0]+"-"+person[1]);
            list.add(person[1],person);
        }
        int[][] res = new int[people.length][2];
        list.toArray(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
