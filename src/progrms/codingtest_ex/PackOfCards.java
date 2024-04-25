package progrms.codingtest_ex;
import java.util.*;

public class PackOfCards {
   public String solution(String[] cards1, String[] cards2, String[] goal) {

      Queue<String> queue1 = new LinkedList<>();
      for(String s : cards1) queue1.offer(s);

      Queue<String> queue2 = new LinkedList<>();
      for(String s : cards2) queue2.offer(s);

      int count = 0;
      for(String s : goal){

         if(s.equals(queue1.peek())){
            System.out.println("queue1.get()"+queue1.poll());
            count++;
         }

         if(s.equals(queue2.peek())){
            System.out.println("queue2.get():"+queue2.poll());
            count++;
         }
      }

      return goal.length == count? "Yes" : "No";
   }
}
