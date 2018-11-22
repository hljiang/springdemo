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
                    System.out.println("[buyDay:{" + (buyDay+1) + "} day, buyPrice: {" + prices[buyDay] +"}]");
                    int profit = calucate(prices, salesDay + 1) + (prices[salesDay] - prices[buyDay]);
                    System.out.println("[saleDay:{" + (salesDay+1) + "} day, salesPrice: {" + prices[salesDay]
                            + "}, profit: {" + profit +"}]");
                    max = Math.max(max,profit);
                    System.out.println("***********[loop,max{" + max +"}]*************");
                }
            }
            maxprofit = Math.max(max, maxprofit);
        }
        return maxprofit;
    }


    public int maxProfit(int[] prices) {
        return calucate(prices,0);
    }


    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution122.maxProfit(prices));
    }
}

