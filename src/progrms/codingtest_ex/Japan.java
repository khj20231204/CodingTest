package progrms.codingtest_ex;
import java.util.*;
public class Japan {
   public int[] solution(String[] keymap, String[] targets) {
      int[] answer = {};

      String keymapAll = "";
      for(String s : keymap){
         keymapAll += s;
      }

      String targetsAll = "";
      for(String s : targets){
         targetsAll += s;
      }

      int check = 0;
      for(char c : targetsAll.toCharArray()){
         check = keymapAll.indexOf(c);
      }

      if(check == -1) return new int[]{-1};

      //keymap1과 keymap2의 indexOf 안에서 targets1 검색 끝나면 targets2검색
      List<Integer> listTotal = new ArrayList<>();
      List<Integer> answerList = new ArrayList<>();

      for(String s : targets){ //"ABCD"
         int sum = 0;

         for(char c : s.toCharArray()){ //'A','B','C'

            int tmp = 100;
            for(String s2 : keymap){
               int idx = s2.indexOf(c);
               if(tmp > idx && idx != -1) tmp = idx;
            }
            //System.out.println(listTotal);
            sum += tmp;
         }
         answerList.add(sum);
      }

      return answerList.stream().mapToInt(Integer::intValue).toArray();
   }
}
