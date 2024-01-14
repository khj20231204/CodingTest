package ch2.list_ex;/*
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.

입출력 예
n	    return
12345	[5,4,3,2,1]
*/

import java.util.*;

public class _3_reverse_natural_number {
    public int[] solution1(long n) {
        LinkedList<Integer> list = new LinkedList<>();

        while(n>0){
            list.add((int)(n % 10));
            n = n/10;
            System.out.println("n:"+n);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
