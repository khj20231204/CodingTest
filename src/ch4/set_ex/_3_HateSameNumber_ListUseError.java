package ch4.set_ex;

import java.util.*;

public class _3_HateSameNumber_ListUseError {
   public int[] solution(int []arr) {
      int[] answer = {};

      List<Integer> list = new LinkedList<>();
      list.add(arr[0]);

      for(int i=1 ; i<arr.length ; i++){

         //error가 발생하는 이유
         //list의 사이즈가 arr의 사이즈보다 작은 경우가 발생
         if(list.get(i-1) == arr[i]) continue;
         //if(arr[i-1] == arr[i]) continue;

         list.add(arr[i]);
      }

      return list.stream().mapToInt(Integer::intValue).toArray();
   }
}
