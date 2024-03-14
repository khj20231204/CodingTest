package ch4.set_ex;

import java.util.*;

public class ch4_Main {
    public static void main(String[] args){

        SetEx se = new SetEx();
        //se.setEx();

        _3_HateSameNumber_ListUseError hsnError = new _3_HateSameNumber_ListUseError();
        //hsnError.solution(new int[]{1,1,3,3,0,1,1});

        //list, set, map에서 중복값이 있는 경우 입력과 삭제
        //1)list
        List<Integer> list = new ArrayList<>(); //중복 입력 가능
        list.add(5);
        list.add(7);
        list.add(5);
        //list:[5, 7, 5]

        //중복 위치에 덮어쓴다
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(7);
        set.add(5);
        //set:[5, 7]

        //중복 위치에 덮에 쓴
        Map<Integer,String> map = new HashMap<>(); //
        map.put(5,"5");
        map.put(7,"7");
        map.put(5,"55");
        //map:{5=55, 7=7}

        System.out.println("list:"+list+" ,set:"+set+" ,map:"+map);

        list.remove(0);
        set.remove(5);
        map.remove(5);
        //list의 remove만 index, set은 값, map는 key로 remove
        System.out.println("list:"+list+" ,set:"+set+" ,map:"+map);
    }
}

