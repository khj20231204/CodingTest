package ch5.stackqueue_ex;

import ch6.search_ex.PermutationEx;

import java.util.*;

public class ch5_Main {

    public static void main(String[] args) {

        int result = _4_Print.solution1(new int[]{2,3,5,7,1,8,2,2}, 3);

        //PriorityQueueEx.priorityQueueEx();

        //연산할 때 제수나 피제수 중 하나를 float으로 해야 올림이 가능하다
        int divisor = 5;
        int dividend = 17;

        int v = (int)Math.ceil(dividend/divisor); //3
        int v1 = (int)Math.ceil((float)dividend/divisor); //4
        int v2 = (int)Math.ceil(dividend/(float)divisor); //4

        System.out.println("v:"+v+" ,v1:"+v1+" ,v2:"+v2);

    }
}

