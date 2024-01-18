package ch5.stackqueue_ex;

import java.util.*;

public class _3_StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<prices.length ; i++){
            int a = prices[i];
            int count = 0;
            for(int j=i+1 ; j<prices.length ; j++){
                int b = prices[j];
                count++;
                if(a>b) break;
            }
            stack.push(count);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
