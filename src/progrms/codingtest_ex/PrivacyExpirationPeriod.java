package progrms.codingtest_ex;
import java.util.*;

public class PrivacyExpirationPeriod {
   public int[] solution(String today, String[] terms, String[] privacies) {
      int[] answer = {};

      for(String s : privacies){
         //System.out.println(s);
      }

      String[] str = privacies[1].split(" ");
      for(String s : str){
         //System.out.println(s);
      }

      String ss = "12";
      int aa = Integer.valueOf(ss);
      Integer aa2 = Integer.valueOf(ss);
      int aa3 = Integer.parseInt(ss);
      Integer aa4 = Integer.parseInt(ss);

      //int[] -> String[]
      int[] k = {1,2,34};
      String[] kk = Arrays.stream(k).mapToObj(String::valueOf).toArray(String[]::new);

      //String[] -> int[]
      k = Arrays.stream(kk).mapToInt(Integer::valueOf).toArray();


      return answer;
   }
}
