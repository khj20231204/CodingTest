package ch9.tree_ex;

import java.util.*;

public class _1_MoreSpicy {
   /* 정확성 테스트는 통과 , 효율성 테스트는 실패 */
   public int solutionList(int[] scoville, int K) {

      List<Integer> list = new LinkedList<>();
      for(int s : scoville) list.add(s);

      Collections.sort(list);

      int answer = 0;
      while(list.get(0) < K && list.size() >= 2){
         int s1 = list.remove(0);
         int s2 = list.remove(0);
         int s3 = s1 + s2*2;
         list.add(s3);
         answer++;

         Collections.sort(list);
      }

      if(list.get(0) < K) return -1;

      return answer;
   }

   /* 효율성 테스트도 통과 */
   public int solutionPriorityQueue(int[] scoville, int K) {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      for(int s : scoville) q.offer(s);

      int answer = 0;
      while(q.peek() < K && q.size() >= 2){
         int s1 = q.poll();
         int s2 = q.poll();
         int s3 = s1 + s2*2;
         q.offer(s3);
         answer++;
      }

      if(q.peek() < K) return -1;

      return answer;
   }
   public int solution_error1(int[] scoville, int K) {
      int answer = 0;

      Stack<Integer> stack = new Stack<>();

      for(int i : scoville){
         stack.push(i);
      }

      Collections.sort(stack, Collections.reverseOrder());

      int count = 1;
      while(!stack.isEmpty()){
         if(stack.size() <= 1) return -1;

         int i = stack.pop();
         if(i < K){

            int j = stack.pop();

            stack.push(i+j*2);
            Collections.sort(stack, Collections.reverseOrder());
            System.out.println("stack:"+stack);
            count++;

         }else{
            return count;
         }
      }

      return answer;
   }

   public int solution_error2(int[] scoville, int K) {
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

   public int solution_error3(int[] scoville, int K) {
      int answer = 0;

      List<Integer> list = new ArrayList<>();

      for(int i : scoville){
         list.add(i);
      }

      int cnt = 0;
      while(!list.isEmpty()){
         Collections.sort(list);

         int v1 = list.remove(0); //remove를 한 상태에서

         if(v1 >= K) return answer;
         if(list.size() <= 1) return -1; //여기서 size를 체크했다

         answer++;
         int v2 = list.remove(0);
         //System.out.println("v1:"+v1+" ,v2:"+v2+ " ,list.size():"+list.size());
         list.add(v1+(v2*2));
      }

      return -1;
   }
}
