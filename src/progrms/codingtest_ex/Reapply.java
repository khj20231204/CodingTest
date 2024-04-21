package progrms.codingtest_ex;

public class Reapply {

   //시간 초과
   public int solution1(int n, int m, int[] section) {
      int answer = 1;

      int idx = 0;
      int count = 0;
      while(true){
         int a = section[idx];
         int num = a+m-1;
         count++;
         if(count >= section.length) break;

         if(num > section[count]){
            continue;
         }else if(num == section[count]) {
            count++;
            idx = count;
            answer++;
         }else{
            idx = count;
            answer++;
         }
      }

      return answer;
   }

   //정답
   public int solution2(int n, int m, int[] section) {
      int answer = 1;

      int tmp = section[0]+m-1;
      for(int i : section){

         if(tmp >= i) continue;

         tmp = i+m-1;
         answer++;
      }

      return answer;
   }

   //정답
   public int solution3(int n, int m, int[] section) {
      int answer = 0;
      int start = section[0];
      answer++;

      for (int item : section) {
         if (start + m > item) {
            continue;
         }
         start = item;
         answer++;
      }
      return answer;
   }

}
