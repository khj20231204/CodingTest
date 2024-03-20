package ch5.stackqueue_ex;

import java.util.*;

/* count++ 와 break의 위치 */

public class _3_StockPrice {
    public int[] solution(int[] prices) {

        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<prices.length ; i++){
            int a = prices[i];
            int count = 0;
            for(int j=i+1 ; j<prices.length ; j++){
                int b = prices[j];
                count++; //count++를 break 전인지 후인지에 따라 값 변경
                if(a>b) break;
            }
            stack.push(count);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution_error(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0 ; i<prices.length ; i++){

            int a = prices[i];
            int count = 0;
            for(int j=i+1 ; j<prices.length ; j++){
                //if(a > prices[j]) break;

                count++;
            }

            answer[i] = count;
        }

        System.out.println(answer);

        return answer;
    }
}
