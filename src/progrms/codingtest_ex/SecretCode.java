package progrms.codingtest_ex;
import java.util.*;
import java.util.stream.*;

public class SecretCode {
   public String solution1(String s, String skip, int index) {
      String answer = "";

      int[] sInt = new int[s.length()];
      int[] skipInt = new int[skip.length()];
      List<Integer> list = new ArrayList<>();

      for(int i=0 ; i<s.length() ; i++){
         sInt[i] = (int)s.charAt(i);
      }

      for(int i=0 ; i<skip.length() ; i++){
         skipInt[i] = (int)skip.charAt(i);
         list.add((int)skip.charAt(i));
      }

      //97~122
      for(int i=0 ; i<sInt.length ; i++){
         int count = 0;
         for(int j=1 ; j<=index ; j++){
            int tmp = sInt[i]+j;
            if(tmp>122) tmp -= 26;
            if(list.contains(tmp)) count++;
                /*
                for(int k=0 ; k<skipInt.length ; k++){
                    if(tmp == skipInt[k]) count++;
                }*/
         }

         sInt[i] = sInt[i]+count+index;
         if(sInt[i] > 122) sInt[i] -= 26;
      }

      char[] result = new char[sInt.length];
      for(int i=0 ; i<result.length; i++){
         result[i] = (char)sInt[i];
      }

      answer = String.valueOf(result);

      return answer;
   }

   public String solution2(String s, String skip, int index) {
      String answer = "";

      int[] sInt = new int[s.length()];
      int[] skipInt = new int[skip.length()];
      List<Integer> list = new ArrayList<>();

      for(int i=0 ; i<s.length() ; i++){
         sInt[i] = (int)s.charAt(i);
      }

      for(int i=0 ; i<skip.length() ; i++){
         skipInt[i] = (int)skip.charAt(i);
         list.add((int)skip.charAt(i));
      }

      //97~122
      for(int i=0 ; i<sInt.length ; i++){
         int count = 0;
         for(int j=1 ; j<=index ; j++){
            int tmp = sInt[i]+j;
            if(tmp>122) tmp -= 26;
            if(list.contains(tmp)) count++;
                /*
                for(int k=0 ; k<skipInt.length ; k++){
                    if(tmp == skipInt[k]) count++;
                }*/
         }

         sInt[i] = sInt[i]+count+index;
         if(sInt[i] > 122) sInt[i] -= 26;
      }

      char[] result = new char[sInt.length];
      for(int i=0 ; i<result.length; i++){
         result[i] = (char)sInt[i];
      }

      answer = String.valueOf(result);

      return answer;
   }
}
