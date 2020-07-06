//二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 案例: 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 注意事项: 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 
// Related Topics 位运算 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二进制手表
public class P401BinaryWatch{
    public static void main(String[] args) {
        Solution solution = new P401BinaryWatch().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<String> res;
    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        if (num == 0){
            res.add("0:00");
            return res;
        }
        //每个位置对应的时间
        int[] arr = new int[]{8,4,2,1,32,16,8,4,2,1};
        backTrack(num,arr,0,0,0);
        return res;
    }
    public void backTrack(int num,int[] arr, int start, int hour, int minute){
        if (num==0){
            if (hour>11 || minute > 59){
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(hour);
            sb.append(":");
            if (minute<10){
                sb.append("0");
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            //判断是小时还是分钟
            if (i<4){
                hour += arr[i];
            }else {
                minute += arr[i];
            }
            backTrack(num-1,arr,i+1,hour,minute);
            if (i<4){
                hour -= arr[i];
            }else {
                minute -= arr[i];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
