//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


import java.util.Stack;

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

        int n = T.length;
        int[] dist = new int[n];//存储结果，也就是距离温度高的天数
        Stack<Integer> stack = new Stack<>();
        for (int curi = 0; curi < n; curi++) {
            while(!stack.isEmpty() && T[curi] > T[stack.peek()]){
                //进入循环说明 找到了升温天数
                //将栈顶元素出栈
                int prei = stack.pop();
                //距离
                dist[prei] = curi - prei;
            }
            stack.add(curi);//如果栈为空 或者 当前温度比栈顶元素温度高，就把当前温度加入栈
            //这个栈顶相当于正在处理的当前天数
        }
        return dist;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
