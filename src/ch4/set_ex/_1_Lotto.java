package ch4.set_ex;

import java.util.*;

public class _1_Lotto {
    public boolean solution(int[] lotto) {
        boolean answer = true;

        //Set이용
        Set<Integer> set = new HashSet();
        for(int i : lotto){
            if(i<1 || i>45) return false;
            set.add(i);
        }
        //return set.size() == lotto.length ? true : false;

        //list.contains이용
        List<Integer> list = new ArrayList<>();
        for(int i : lotto){
            if(i<1 || i>45) return false;
            if(list.contains(i))
                return false;

            list.add(i);
        }
        int listMax = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        int listMin = list.stream().mapToInt(Integer::intValue).min().getAsInt();
        //return true;

        //stream이용
        int count = (int)Arrays.stream(lotto).distinct().count();
        int max = Arrays.stream(lotto).max().getAsInt();
        int min = Arrays.stream(lotto).min().getAsInt();

        if(count != lotto.length) answer = false;
        else if(max > 45 || min < 1) answer = false;

        return answer;
    }
}
