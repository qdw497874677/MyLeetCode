//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package com.qdw.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原IP地址
public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length()<=3){
            return res;
        }
        find(s,0,1);
        return res;
    }
    public void find(String s,int index,int count){
        if (count==4){
            if (s.length()-index<=3){
                String subs = s.substring(index,s.length());
                if (check(subs)){
                    res.add(s);
                }
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            //检查是否越界
            if (index+i>=s.length()){
                continue;
            }
            StringBuffer sb = new StringBuffer(s);
            String subs = sb.substring(index,index+i);
            if (check(subs)){
                sb.insert(index+i,'.');
                find(sb.toString(),index+i+1,count+1);
            }
        }
    }
    //检查子串是否符合要求，<=255,>=0,如果不是0第一位不能是0
    public boolean check(String subs){
        int a = Integer.parseInt(subs);
        if (a<=255 && a>=0 && String.valueOf(a).length() == subs.length()){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
