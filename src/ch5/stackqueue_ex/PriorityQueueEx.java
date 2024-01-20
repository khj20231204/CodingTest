package ch5.stackqueue_ex;

import java.util.*;

public class PriorityQueueEx {

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // priorities 값
        for (int i : priorities) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {  //priorities와 queue를 비교
                    if (location == i) { //priorities의 인덱스인 location과 i를 비
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}
