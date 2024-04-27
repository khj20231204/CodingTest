package progrms.codingtest_ex;
import java.util.*;
import java.util.stream.*;

public class SecretCode {
   public String solution(String s, String skip, int index) {
      String answer = "";
      //소문자65~90 97~122 26개
      //skip의 수만틈 index를 더한다

      //char[] -> List<Character>
      char[] skipChar = skip.toCharArray();

      int[] sInt = new int[];
      for(char c3 : skipChar)  {System.out.println((int)c3);}
      List<Character> list = IntStream.range(0,skipChar.length).mapToObj(i->skipChar[i]).collect(Collectors.toList());

      //char[] -> List<char[]>
      List<char[]> list2 = Arrays.asList(skipChar); //contains는 가능




      return answer;
   }
}
