//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：直线上最多的点数
public class P149MaxPointsOnALine{
    public static void main(String[] args) {
        Solution solution = new P149MaxPointsOnALine().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length==1){
            return 1;
        }
        int res = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            //与i重合的点的个数
            int r = 0;
            //以i为基准的直线上最长点数量
            int tempMax = 0;
            for (int j = 0; j < points.length; j++) {
                int a = points[j][0]-points[i][0];
                int b = points[j][1]-points[i][1];
                if (a==0 && b==0){
                    r++;
                    continue;
                }
                int gcd = gcd(a,b);
                String s = a/gcd+"/"+b/gcd;
                Integer num = map.get(s);
                if (num==null){
                    num=0;
                }
                map.put(s,num+1);
                tempMax = Math.max(tempMax,num+1);
            }
            res = Math.max(res,tempMax+r);
            map.clear();
        }
        return res;
    }
    //辗转相除求公约数
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
