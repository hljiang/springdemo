package com.hljiang.leetcode;

import java.util.*;

/**
 * 买卖股票获取最大利益
 */
public class Solution122 {
    //最开始的思路，但是只能说是近似解，不一定是最优解,递归如何用进来才是入门greedy algorithm
    public int calucate(int[] prices, int startday) {
        int maxprofit = 0;
        for (int buyDay = startday; buyDay < prices.length; buyDay++) {
            int max = 0;
            for (int salesDay = buyDay + 1; salesDay < prices.length; salesDay++) {
                if (prices[salesDay] > prices[buyDay]) {
                    System.out.println("[buyDay:{" + (buyDay + 1) + "} day, buyPrice: {" + prices[buyDay] + "}]");
                    int profit = calucate(prices, salesDay + 1) + (prices[salesDay] - prices[buyDay]);
                    System.out.println("[saleDay:{" + (salesDay + 1) + "} day, salesPrice: {" + prices[salesDay]
                            + "}, profit: {" + profit + "}]");
                    max = Math.max(max, profit);
                    System.out.println("***********[loop,max{" + max + "}]*************");
                }
            }
            maxprofit = Math.max(max, maxprofit);
        }
        return maxprofit;
    }


    public int maxProfit(int[] prices) {
        return calucate(prices, 0);
    }

    public int maxProfitUpdate(int[] prices) {
        List<Integer> peaks = new ArrayList<>();
        List<Integer> valleys = new ArrayList<>();
        if (prices.length < 2) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int start = prices[0];
        boolean isDown = false;
        for (int i = 1; i < prices.length; i++) {
            start = prices[i - 1];
            isDown = prices[i] < start;
            for (int j = i + 1; j < prices.length; j++) {
                if (isDown && prices[j-1] < prices[j]) {
                    //下降趋势,j是拐点
                    valleys.add(prices[j - 1]);
                    i = j - 1;
                    break;
                }
                if (!isDown && prices[j-1] > prices[j]) {
                    peaks.add(prices[j - 1]);
                    if(valleys.size()==0){
                        valleys.add(prices[0]);
                    }
                    i = j - 1;
                    break;
                }
            }
        }

        if(!isDown){
            peaks.add(prices[prices.length-1]);
            if(valleys.size()==0){
                valleys.add(prices[0]);
            }
        }

        int profit = 0;
        int length = Math.min(peaks.size(), valleys.size());

        for (int i = 0; i < length; i++) {
            profit = profit + (peaks.get(i) - valleys.get(i));
        }
        return profit;
    }


    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] prices = new int[]{1,4,2};
        System.out.println(solution122.maxProfitUpdate(prices));
    }
}

