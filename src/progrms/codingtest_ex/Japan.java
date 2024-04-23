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

      int index = 0;
      for(String s : targets){ //"ABCD"
         int total = 0;
         int v2 = 0;
         for(char c : s.toCharArray()){ //'A' 'B' 'C' 'D'
            int v1 = max;
            for(String s2 : keymap){
               v2 = s2.indexOf(c);

               if(v2 != -1){
                  if(v1 > v2) v1 = v2;
               }

               //System.out.println("v1:"+v1+" ,v2:"+v2);
            }

            if(v1 == max){
               return new int[]{-1};
            }else{
               total += (v1+1);
               //System.out.println("total:"+total);
            }
         }
         answer[index] = total;
         index++;
      }

      return answer;
   }
}
