package ch5.stackqueue_ex;

import java.util.LinkedList;
import java.util.List;

public class ListMakeQueueStack {
    public void listMakeQueueStack(){

        //List 를 통한 Stack과 Queue 구현

        /* List의 remove는 값을 꺼내오고 list에서 삭제, index를 0으로 할 건지, 아니면 마지막 값으로 할 건지에 따라 queue와 stack이 구현
        index를 0으로 - queue
        index를 마지막index로 - stack */

        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        // index=0 으로 queue 구현
        System.out.println(list); //[1, 2, 3]

        System.out.println(list.remove(0)); //1
        System.out.println(list); //[2, 3]

        System.out.println(list.remove(0)); //2
        System.out.println(list); //[3]

        System.out.println(list.remove(0)); //3
        System.out.println(list); //[]

        // index를 마지막 값으로 stack 구현
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.remove(list.size()-1)); //3
        System.out.println(list); //[1, 2]

        System.out.println(list.remove(list.size()-1)); //2
        System.out.println(list); //[1]

        System.out.println(list.remove(0)); //1
        System.out.println(list); //[]
    }
}
