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
}
