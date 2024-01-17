package ch5.stackqueue_ex;

import java.util.*;

public class StackQueueEx {
    public void stackQueueEx(){
        //------------------------- queue -------------------------
        /*Queue는 인터페이스만 제공, Queue를 상속 받은 LinkedList로 구현*/
        Queue<Integer> queue = new LinkedList<Integer>();

        /* offer(e)-element를 추가*/
        System.out.println(queue.offer(1)); //true
        System.out.println(queue.offer(2)); //true
        System.out.println(queue.offer(3)); //true
        System.out.println(queue.offer(1)); //true
        System.out.println(queue); //[1, 2, 3, 1]

        /* peek()-꺼낼 element를 조회 */
        System.out.println(queue.peek()); //1

        /* poll()-element를 꺼내오고 queue에서 삭제, 더이상 값이 없으면 null반환 */
        System.out.println(queue.poll()); //1
        System.out.println(queue.poll()); //2

        System.out.println(queue.peek()); //3,peek로 다음 나올 값을 조회
        System.out.println(queue.poll()); //3

        System.out.println(queue.poll()); //1
        System.out.println(queue.poll()); //queue에 값이 없으면 null반환

        //------------------------- stack -------------------------
        Stack<Integer> stack = new Stack<Integer>();

        /* push(e)-stack에 값을 입력 */
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println(stack); //[1, 2, 3, 1]

        /* peek()-꺼낼 element를 조회 */
        System.out.println(stack.peek()); //1

        /* pop()-stack에서 값을 꺼낼 때 */
        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //3

        System.out.println(stack.peek()); //2, peek로 꺼낼 값 조회
        System.out.println(stack.pop());  //2

        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //error, stack에 값이 없는데 pop를 하면 error발생

        //------------------------- Deque -------------------------
        Deque<Integer> deque = new LinkedList<Integer>();

        /* offerFirst-가장 앞 위치에 삽입, offerLast-가장 뒤 위치에 삽입 */
        System.out.println(deque.offerFirst(1)); //true
        System.out.println(deque.offerFirst(2)); //true
        System.out.println(deque.offerLast(3));  //true
        System.out.println(deque.offerLast(4));  //true
        System.out.println(deque); //[2, 1, 3, 4]

        /* peekFirst-가장 앞 위치에 요소 검색, peekLast-가장 뒤 위치에 요소 검색 */
        System.out.println(deque.peekFirst()); //2
        System.out.println(deque.peekLast());  //4

        /* pollFirst-가장 앞 위치 요소 출력, pollLast-가장 뒤 위치 요소 출력 */
        System.out.println(deque.pollFirst()); //2
        System.out.println(deque.pollLast());  //4
        System.out.println(deque.pollFirst()); //1
        System.out.println(deque.pollLast());  //3

        System.out.println(deque.pollFirst()); //null, 요소가 없으면 null반환
        System.out.println(deque.pollLast());  //null, 요소가 없으면 null반환
    }
}
