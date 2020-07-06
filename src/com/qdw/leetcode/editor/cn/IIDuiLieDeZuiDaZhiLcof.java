//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O
//(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window


package com.qdw.leetcode.editor.cn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：队列的最大值
public class IIDuiLieDeZuiDaZhiLcof{
    public static void main(String[] args) {
//        Solution solution = new IIDuiLieDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {

    private Queue<Integer> queue;
    private Queue<Integer> queueP;
    int max;

    public MaxQueue() {
        max = -1;
        queue = new LinkedList<>();
        queueP = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//大的在队前面
            }
        });
    }
    
    public int max_value() {
        if(queueP.size()==0){
            return -1;
        }
        return queueP.peek();
    }
    
    public void push_back(int value) {

        queue.add(value);
        queueP.add(value);
    }
    
    public int pop_front() {
        if(queue.size()==0){
            return -1;
        }
        int res = queue.poll();
        queueP.remove(res);
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
