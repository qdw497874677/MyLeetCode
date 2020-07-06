//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


package com.qdw.leetcode.editor.cn;

import java.util.Stack;

//Java：每日温度
public class P739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
//        int[] a = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            int temp = 1;
//            for (int j = i+1; j < T.length; j++) {
//                if (T[i] < T[j]){
//                    a[i] = temp;
//                    break;
//                }else {
//                    temp++;
//                }
//
//            }
//        }
//        a[T.length-1] = 0;
//        return a;

//            //反向循环
//            int n = T.length;
//            int[] dist = new int[n];
//
//            for (int i = n-2; i >= 0; i--) {
//                //j的增加是j的升温天数，如果是0就说明不会再升温了，省去多余的判断
//                for (int j = i+1; j < n; j+=dist[j]) {
//                    if(T[i] < T[j]){
//                        dist[i] = j-i;
//                        break;
//                    }else if(dist[j] == 0){
//                        dist[i] = 0;
//                        break;
//                    }
//
//                }
//            }
//            return dist;


            int[] ans = new int[T.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < T.length; i++) {
                while (!stack.isEmpty() && T[stack.peek()]<T[i]){
                    Integer pop = stack.pop();
                    ans[pop] = i-pop;
                }
                stack.add(i);
            }
            return ans;




//            int n = T.length;
//            int[] dist = new int[n];//存储结果，也就是距离温度高的天数
//            Stack<Integer> stack = new Stack<>();//栈中存储序号，即第几天
//            for (int curi = 0; curi < n; curi++) {
//                //当栈不为空，且当前温度比栈顶温度高，就找到了栈顶元素的升温天数
//                //即当前温度的序号减去栈顶存的序号
//                while(!stack.isEmpty() && T[curi] > T[stack.peek()]){
//                    //找到栈顶升温那天 就 栈顶出栈
//                    int prei = stack.pop();
//                    //记录下栈顶元素的升温天数
//                    dist[prei] = curi - prei;
//                }
//                //如果栈为空 或者 当前元素比栈顶元素小，就把当前元素的序号入栈
//                stack.add(curi);
//
//            }
//            return dist;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
