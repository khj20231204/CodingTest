package progrms.codingtest_ex;
import java.util.*;
public class RecollectionNumber {
   public int[] solution(String[] name, int[] yearning, String[][] photo) {
      int[] answer = new int[photo.length];

      Map<String, Integer> map = new HashMap<>();
      for(int i=0 ; i<name.length ; i++){
         map.put(name[i], yearning[i]);
      }

      int index = 0;
      for(String[] s : photo){
         int max=0;
         for(String s2 : s){
            if(map.containsKey(s2)){
               int num = map.get(s2);
               System.out.println(num);
               max += num;
            }
         }
         answer[index++] = max;
      }

      return answer;
   }
}
