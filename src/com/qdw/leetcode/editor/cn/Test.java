package com.qdw.leetcode.editor.cn;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.test1());
    }

    public int test1(int W, int N, int[] weights, int[] values){
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i < N + 1; i++) {
            int w = weights[i-1];
            int v = values[i-1];
            for (int j = 0; j < W+1; j++) {
                //如果当前要考虑的i物品的体积小于当前的容量j的话，i物品可以装
                if (w<=j){
                    //装不装，要比较j容量装i-1件物品价值高，还是把第i件装上，即j-w的容量装i-1件物品的价值加上第i件的价值，那个更大
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j] > arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            res[i] = arr[arr.length-i-1];
        }
        return res;
    }
}
