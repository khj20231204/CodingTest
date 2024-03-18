package ch4.set_ex;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class ch4_Main {
    public static void main(String[] args){

        SetEx se = new SetEx();
        //se.setEx();

        _3_HateSameNumber_ListUseError hsnError = new _3_HateSameNumber_ListUseError();
        //hsnError.solution(new int[]{1,1,3,3,0,1,1});

        //list, set, map에서 중복값이 있는 경우 입력과 삭제

        //------------- add ----------------
        //1)list
        List<Integer> list = new ArrayList<>(); //중복 입력 가능
        list.add(5);
        list.add(7);
        list.add(5);
        //list:[5, 7, 5]

        ListIterator listIter1 = list.listIterator();
        while(listIter1.hasNext()){
            System.out.println("listIter1:"+listIter1.next());
        }
        System.out.println();
        Iterator listIter2 = list.iterator();
        while(listIter2.hasNext()) {
            System.out.println("listIter2:" + listIter2.next());
        }

        //element가 같은 중복 위치에 덮어쓴다
        //*set은 순서가 없기 때문에 index가 없다
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(7);
        set.add(5);
        //set:[5, 7]
        System.out.println();
        Iterator setIter = set.iterator();
        while(setIter.hasNext()){
            System.out.println("setIter:"+setIter.next());
        }

        //key가 같은 중복 위치에 덮어쓴다
        Map<Integer,String> map = new HashMap<>(); //
        map.put(5,"67");
        map.put(7,"89");
        map.put(5,"96");
        //map:{5=55, 7=7}
        System.out.println();
        Iterator mapKeyIter = map.keySet().iterator();
        while(mapKeyIter.hasNext()){
            System.out.println("mapKeyIter:"+mapKeyIter.next());
        }

        Iterator mapValueIter = map.values().iterator();
        while(mapValueIter.hasNext()){
            System.out.println("mapValueIter:"+mapValueIter.next());
        }

        //------------- remove ----------------
        list.remove(0);
        set.remove(5);
        map.remove(5);
        //list의 remove만 index, set은 값, map는 key로 remove
        System.out.println("list:"+list+" ,set:"+set+" ,map:"+map);

        int[] aa = new int[]{11,2,3};
        int k = aa.length;
    }
}

