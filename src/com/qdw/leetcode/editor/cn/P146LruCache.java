//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package com.qdw.leetcode.editor.cn;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Java：LRU缓存机制
public class P146LruCache{
    public static void main(String[] args) {
        LRUCache solution = new P146LruCache().new LRUCache(2);
        solution.put(1,1);
        solution.put(2,2);
        System.out.println(solution.get(1));
//        solution.put(3,3);
//        solution.get(2);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//    public class LRUCache {
//
//        private Map<Integer, ListNode> map;
//
//        /**
//         * 双链表结点类
//         */
//        private class ListNode {
//
//            private Integer key;
//            private Integer value;
//            /**
//             * 前驱结点 precursor
//             */
//            private ListNode pre;
//            /**
//             * 后继结点 successor（写成 next 是照顾单链表的表示习惯）
//             */
//            private ListNode next;
//
//            public ListNode() {
//            }
//
//            public ListNode(Integer key, Integer value) {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//        private int capacity;
//
//        /**
//         * 虚拟头结点没有前驱
//         */
//        private ListNode dummyHead;
//        /**
//         * 虚拟尾结点没有后继
//         */
//        private ListNode dummyTail;
//
//        public LRUCache(int capacity) {
//            map = new HashMap<>(capacity);
//            this.capacity = capacity;
//            dummyHead = new ListNode(-1, -1);
//            dummyTail = new ListNode(-1, -1);
//            // 初始化链表为 head <-> tail
//
//            dummyHead.next = dummyTail;
//            dummyTail.pre = dummyHead;
//        }
//
//        /**
//         * 如果存在，把当前结点移动到双向链表的头部
//         *
//         * @param key
//         * @return
//         */
//        public int get(int key) {
//            if (map.containsKey(key)) {
//                ListNode node = map.get(key);
//                int val = node.value;
//
//                // 把当前 node 移动到双向链表的头部
//                moveNode2Head(key);
//                return val;
//            } else {
//                return -1;
//            }
//        }
//
//        /**
//         * 如果哈希表的容量满了，就要删除一个链表末尾元素，然后在链表头部插入新元素
//         *
//         * @param key
//         * @param value
//         */
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                // 1、更新 value
//                map.get(key).value = value;
//                // 2、把当前 node 移动到双向链表的头部
//                moveNode2Head(key);
//                return;
//            }
//
//            // 放元素的操作是一样的
//
//            if (map.size() == capacity) {
//                // 如果满了
//                ListNode oldTail = removeTail();
//
//                // 设计 key 就是为了在这里删除
//                map.remove(oldTail.key);
//            }
//
//            // 然后添加元素
//            ListNode newNode = new ListNode(key, value);
//            map.put(key, newNode);
//            addNode2Head(newNode);
//        }
//
//        // 为了突出主干逻辑，下面是 3 个公用的方法
//
//        /**
//         * 删除双链表尾部结点
//         */
//        private ListNode removeTail() {
//            ListNode oldTail = dummyTail.pre;
//            ListNode newTail = oldTail.pre;
//
//            // 两侧结点建立连接
//            newTail.next = dummyTail;
//            dummyTail.pre = newTail;
//
//            // 释放引用
//            oldTail.pre = null;
//            oldTail.next = null;
//
//            return oldTail;
//        }
//
//        /**
//         * 把当前 key 指向的结点移到双向链表的头部
//         *
//         * @param key
//         */
//        private void moveNode2Head(int key) {
//            // 1、先把 node 拿出来
//            ListNode node = map.get(key);
//
//            // 2、原来 node 的前驱和后继接上
//            node.pre.next = node.next;
//            node.next.pre = node.pre;
//
//            // 3、再把 node 放在末尾
//            addNode2Head(node);
//        }
//
//        /**
//         * 在双链表的头部新增一个结点
//         *
//         * @param newNode
//         */
//        private void addNode2Head(ListNode newNode) {
//            // 1、当前头结点
//            ListNode oldHead = dummyHead.next;
//
//            // 2、末尾结点的后继指向新结点
//            oldHead.pre = newNode;
//
//            // 3、设置新结点的前驱和后继
//            newNode.pre = dummyHead;
//            newNode.next = oldHead;
//
//            // 4、更改虚拟头结点的后继结点
//            dummyHead.next = newNode;
//        }
//
//    }

//class LRUCache {
//        int capacity;
//        Map<Integer,Node> map;
//        Node head;
//        Node tail;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>(capacity);
//        head = new Node(-1, -1);
//        tail = new Node(-1,-1);
//        head.next = tail;
//        tail.pre = head;
//    }
//    public int get(int key) {
//        Node node = map.get(key);
//        if (node==null){
//            return -1;
//        }
//        move2Head(node);
//        return node.val;
//    }
//
//    public void put(int key, int value) {
//        Node node = map.get(key);
//        if (node==null){
//            node = new Node(key,value);
//            map.put(key,node);
//            addNew(node);
//            if (map.size()>capacity){
//                System.out.println(tail.pre.key);
//                map.remove(tail.pre.key);
//                removeTail();
//            }
//        }else {
//            node.val = value;
//            move2Head(node);
//        }
//
//    }
//    public void removeTail(){
//        if (tail.pre !=head){
//            Node oldTail = tail.pre;
//            Node newTail = oldTail.pre;
//            newTail.next = tail;
//            tail.pre = newTail;
//
//            oldTail.pre = null;
//            oldTail.next = null;
//        }
//    }
//    public void move2Head(Node node){
//        if (node.pre ==head){
//            return;
//        }
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//        addNew(node);
//    }
//    public void addNew(Node node){
//        Node oldHead = head.next;
//        oldHead.pre = node;
//        node.next = oldHead;
//        node.pre = head;
//        head.next = node;
//    }
//
//}
//class Node{
//        int key;
//        int val;
//        Node next;
//        Node pre;
//        public Node(int key,int val){
//            this.key = key;
//            this.val = val;
//            next = null;
//            pre = null;
//        }
//    }


    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;
        public LRUCache(int capacity) {
            // 这里的 accessOrder 默认是为false，如果要按读取顺序排序需要将其设为 true
            // initialCapacity 代表 map 的 容量，loadFactor 代表加载因子 (默认即可)
            super(capacity,0.75F,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        //重写这个方法来规定什么时候删除最老的元素，返回true就会删除最老的元素
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size()>capacity;
        }
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
