package ch5.stackqueue_ex;

import java.util.*;

public class _1_RightParenthesis {

    boolean solution(String s) {
        //앞에 걸 뺀다 queue
        Queue<Integer> queue = new LinkedList<>();

        for(char c : s.toCharArray()){

            if(c == '(') queue.offer(1);
            if(queue.peek() == null) return false;
            if(c == ')') queue.poll();

        }
        //return (queue.peek() == null) ? true : false;

        //뒤에 걸 뺀다 stack
        Stack<Integer> stack = new Stack<>();

        for(char c : s.toCharArray()){

            if(c == '(') stack.push(1);
            if(stack.empty()) return false;
            if(c == ')') stack.pop();
        }
        //return (stack.empty()) ? true : false;

        //일반 변수 이용
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '(') count++;
            if(count == 0) return false;
            if(c == ')') count--;
        }
        return (count == 0) ? true : false;
    }

}
