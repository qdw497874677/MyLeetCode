//给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其
//大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于num1中的数字2，第二个数组中的下一个较大数字是3。
//    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
// 
//
// 注意: 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈


package com.qdw.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：下一个更大元素 I
public class P496NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

//        int[] res = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if(nums2[j] == nums1[i]){
//                    for (int k = j; k < nums2.length; k++) {
//                        if(nums1[i] < nums2[k]){
//                            res[i] = nums2[k];
//                            break;
//                        }
//                        if(k == nums2.length-1){
//                            res[i] = -1;
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//        return res;


        Stack<Integer> stack = new Stack<>();
        //之所以要用map的原因是，两个数组长度不同，找下一个最大要在大的数组里找
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        //注意 要循环的是大的数组的所有数
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.add(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        //把小数组里的数挑出来
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;




//        Stack<Integer> stack = new Stack<>();
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        //把结果先存到哈希表里
//        Map<Integer,Integer> map = new HashMap<>();
//        int[] res = new int[nums1.length];
//
//        for(int curi=0;curi<n2;curi++){
//            while (!stack.isEmpty() && nums2[curi]>stack.peek()){
//                map.put(stack.pop(),nums2[curi]);
//            }
//            stack.add(nums2[curi]);
//        }
//        while (!stack.isEmpty()){
//            map.put(stack.pop(),-1);
//        }
//        for(int i=0;i<n1;i++){
//            res[i] = map.get(nums1[i]);
//        }
//        return res;

//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        int[] res = new int[n1];
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = n2-2; i >= 0; i--) {
//            for (int j = i+1; j < n2; j+=map.get(nums2[j]-i)) {
//                if (nums2[j] > nums2[i]){
//                    map.put(nums2[i],j);
//                    break;
//                }else if(!map.containsKey(nums2[j]) || map.get(nums2[j])==0){
//                    map.put(nums2[i],0);
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < n1; i++) {
//
//            res[i] = nums2[map.get(nums1[i])]!=0?nums2[map.get(nums1[i])]:-1;
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
