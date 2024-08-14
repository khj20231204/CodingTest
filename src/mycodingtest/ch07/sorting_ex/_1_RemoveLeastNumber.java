package mycodingtest.ch07.sorting_ex;

import java.util.*;
import java.util.stream.*;

public class _1_RemoveLeastNumber {
	 public int[] solution(int[] arr) {
        int[] answer = {};
        
        int len = arr.length;
        if(len <= 1) return new int[]{-1};
        
        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        list.remove(list.indexOf(min));
        System.out.println("aaaaaaaaaaaaaaaaa");
        return list.stream().mapToInt(Integer::intValue).toArray();
	 }
}
