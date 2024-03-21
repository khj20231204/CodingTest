package ch5.stackqueue_ex;

import java.util.*;

/* count++ 와 break의 위치 */

public class _3_StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0 ; i<prices.length ; i++){
            int price = prices[i];
            int sum = 0;

            //i가 4면 밑에 for문이 안돈다
            for(int j=i+1; j<prices.length ; j++){
                sum++;

                if(price > prices[j]) break;
            }
            answer[i] = sum;
        }
        return answer;
    }

    public int[] solution2(int[] prices) {

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

    public int[] solution3(int[] prices) {
        int[] answer = new int[prices.length];

        //증가 후 자기보다 크다 -> 계속
        //증가 후 자기보다 작다 -> 멈춤

        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<prices.length-1 ; i++){ //1,2,3,2까지 비교
            int count = 0;
            int v = prices[i];
            for(int j=i+1 ; j<prices.length ; j++){ //2,3,2,3까지 비교
                int v2 = prices[j];

                count++;

                if(v <= v2 && j<prices.length-1) continue;
                //System.out.println("count:"+count);
                list.add(count);
                break;
            };
        }
        list.add(0);
        //System.out.println("list:"+list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
