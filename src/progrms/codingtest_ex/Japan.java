package progrms.codingtest_ex;
import java.util.*;
public class Japan {
   //시간 초과
   public int[] solution1(String[] keymap, String[] targets) {
      int[] answer = {};

      //keymap을 character Map에 저장
      //targets값을 char로 String.indexOf 값을 입력

      HashMap<Character, Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      List<Integer> result = new ArrayList<>();

      for(String s : targets){ //"ABCD"
         int total = 0;
         for(char c : s.toCharArray()){ //'A' 'B' 'C' 'D'
            for(String s2 : keymap){
               int idx = (s2.indexOf(c)+1);
               if(idx > 0){
                  list.add(idx);
               }
            }
            //numbers.stream().max(Integer::compare).orElse(-1);
            int min = list.stream().min(Integer::compare).orElse(-1);
            list.clear();
            total += min;
         }
         //System.out.println(total);
         result.add(total);
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
   }

   //error
   public int[] solution2(String[] keymap, String[] targets) {
      int[] answer = new int[targets.length];

      int max = 0;
      for(int i=0 ; i< targets.length ;i++){
         if(max < targets[i].length()) max = targets[i].length()+1;
      }
      max = 101;
      int index = 0;
      for(String s : targets){ //"ABCD"
         int total = 0;
         for(char c : s.toCharArray()){ //'A' 'B' 'C' 'D'
            int v1 = max;
            for(String s2 : keymap){
               int v2 = s2.indexOf(c);

               if(v2 != -1){
                  if(v1 > v2) v1 = v2;
               }
            }

            if(v1 == max){
               return new int[]{-1};
            }else{
               total += (v1+1);
               //System.out.println("total:"+total);
               answer[index] = total;
               index++;
            }
         }
      }
      return answer;
   }

   //error 수정
   public int[] solution3(String[] keymap, String[] targets) {
      int[] answer = new int[targets.length];

      int max = 0;
      for(int i=0 ; i< targets.length ;i++){
         if(max < targets[i].length()) max = targets[i].length()+1;
      }
      max = 101;
      int index = 0;
      for(String s : targets){ //"ABCD" //for1
         for(char c : s.toCharArray()){ //'A' 'B' 'C' 'D' //for2
            int v1 = max;
            for(String s2 : keymap){ //for3
               int v2 = s2.indexOf(c);

               if(v2 != -1){
                  if(v1 > v2) v1 = v2;
               }
            }//for3

            if(v1 == max){
               answer[index] = -1;
               break;
            }else{
               answer[index] += v1+1;
               //System.out.println("v1:"+v1);
            }//else

         }//for2
         index++;
      }//for1
      return answer;
   }

   //정답
   public int[] solution4(String[] keymap, String[] targets) {
      int[] answer = new int[targets.length];

      for(int i=0; i<targets.length; i++) {
         for(int j=0; j<targets[i].length(); j++) {
            int idx = 101;
            for(int k=0; k<keymap.length; k++) {
               int index = keymap[k].indexOf(targets[i].charAt(j));
               if(index != -1) {
                  if(idx > index) {
                     idx = index;
                  }
               }
            }
            if(idx == 101) {
               answer[i] = -1;
               break;
            }
            else {
               answer[i] += idx +1;
            }
         }
      }

      return answer;
   }

   //break와 return
   public int[] solution5(String[] keymap, String[] targets) {
      int[] answer = new int[targets.length];

      int max = 101;
      int index = 0;
      for(String s : targets){
         for(char c : s.toCharArray()){
            int v1 = max;
            for(String s2 : keymap){
               int v2 = s2.indexOf(c);

               if(v2 != -1){
                  if(v1 > v2) v1 = v2;
               }
            }

            if(v1 == max){
               answer[index] = -1;

               break;
               //여기서 한번만 break되고 targets 나머지 경우는 계속 실행된다.

               //return answer;
               //targets가 -1인 경우 이외 뒤에 경우가 실행 안된다. 바로 여기서 종료
               //따라서 바로 return으로 프로그램을 종료시키는 건 위험하다
            }else{
               answer[index] += v1+1;
            }
         }
         index++;
      }

      return answer;
   }

   //error
   public int[] solution6(String[] keymap, String[] targets) {
      int[] answer = new int[targets.length];

      int max = 0;
      for(int i=0 ; i< targets.length ;i++){
         if(max < targets[i].length()) max = targets[i].length()+1;
      }
      max = 101;
      int index = 0;
      boolean check = true;
      for(String s : targets){ //"ABCD" //for1
         int total = 0;
         for(char c : s.toCharArray()){ //'A' 'B' 'C' 'D' //for2
            int v1 = max;
            for(String s2 : keymap){ //for3
               int v2 = s2.indexOf(c);

               if(v2 != -1){
                  if(v1 > v2) v1 = v2;
               }
            }//for3

            if(v1 == max){
               //return new int[]{-1};
               answer[index] = -1;

               check  = false;
               break;
            }else{
               total += (v1+1);
               //answer[index] += v1+1;
            }
         }//for2
         if(check){
            answer[index] = total;
         }
         index++;
      }//for1

      return answer;
   }

}
