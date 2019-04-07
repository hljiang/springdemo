package com.hljiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int bill:bills){
            if(bill == 5){
                five ++;
            }else if(bill == 10){
                if(five ==0){
                    return  false;
                }
                five --;
                ten ++;
            }else{
                if(five>0 && ten>0){
                    five --;
                    ten --;
                }else if (five >=3){
                    five = five -3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans=0;
        int i=0; int j=0;
        while(i<s.length && j<g.length){
            if(s[i]>=g[j]){
                ans++;
                i++;
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}
