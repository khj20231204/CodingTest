package ch5.stackqueue_ex;

import java.util.*;

public class PriorityQueueEx {

    public static void priorityQueueEx(){

        //queue자체는 무작위 순서인데, poll이나 peek를 하면 순서대로 출력
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        queue.offer(52);
        queue.offer(53);
        queue.offer(15);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println("-------------- random --------------");

        Random r = new Random();
        for(int i=0 ; i<10 ; i++){
            queue.offer(r.nextInt(1,30));
        }

        int[] intArry = {1,2,3,3,4,1};
        for(int i : intArry) queue.offer(i);

        while(!queue.isEmpty()){
            for(int i=0 ; i<intArry.length ; i++){
                if(intArry[i] == queue.peek()){

                }
            }

        }

        System.out.println(queue);
        //Comparator.reverseOrder() : 27 15 12 11 8 7 6 5 1 1
        //Comparator.naturalOrder() : 11 12 13 14 15 15 19 20 22 25
    }
}
