package ch9.tree_ex;

import java.util.*;

public class _1_MoreSpicy {

   public int solution(int[] scoville, int K) {
      int answer = 0;

      //List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());

      PriorityQueue<Integer> heap = new PriorityQueue<>();
      for(int i : scoville){
         heap.offer(i);
      }

      int kCheck = 0;

      while(heap.size() >=2) {
         int s1 = heap.poll();
         int s2 = heap.poll();

         int s3 = s1 + s2*2;


         //if(heap.peek() >= K) break;

         heap.offer(s3);
         answer++;
         if(s3 >= K) break;

      }

      if(heap.peek() < K) return -1;

      return answer;
        /*
        while(heap.size()>=2){

            int one = heap.poll();
            int two = heap.poll();

            kCheck = one + two*2;
            //System.out.println("kCheck:"+kCheck);
            answer++;

            if(kCheck >= K) break;

            heap.offer(kCheck);

        }

        if(kCheck >= K) return answer;


        return -1;*/
   }

   public int Mysolution_Error(int[] scoville, int K) {
      int answer = 0;

      Stack<Integer> stack = new Stack<>();

      for(int i : scoville){
         stack.push(i);
      }

      Collections.sort(stack, Collections.reverseOrder());

      int count = 0;
      while(!stack.isEmpty()){
         if(stack.size() <= 1) return -1;

         int i = stack.pop();
         if(i < K){

            int j = stack.pop();

            stack.push(i+j*2);
            Collections.sort(stack, Collections.reverseOrder());
            count++;

         }else{
            return count;
         }
      }

      return answer;
   }

   public int solution_error(int[] scoville, int K) {
      int answer = 0;

      Stack<Integer> stack = new Stack<>();

      for(int i : scoville){
         stack.push(i);
      }

      Collections.sort(stack, Collections.reverseOrder());

      int count = 0;
        /*
        while(!stack.isEmpty()){
            if(stack.size() <= 1) return -1;

            int i = stack.pop();
            if(i < K){

                int j = stack.pop();

                stack.push(i+j*2);
                Collections.sort(stack, Collections.reverseOrder());
                count++;

            }else{
                return count;
            }
        }
        */

      //int count = 0;
      while(stack.size()>=2 && stack.peek() < K){
         int j = stack.pop();
         int l = stack.pop();

         stack.push(j+(l*2));
         Collections.sort(stack, Collections.reverseOrder());
         count++;
      }

      if(stack.size() <= 1) return -1;
      return count;
   }
}
