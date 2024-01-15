package ch3.map_ex;
import java.util.*;
public class _3_Clothes {
    public int solution(String[][] clothes) {

        HashMap<String,Integer> map = new HashMap<>();

        //for문 안에서 clothes전체를 가져와서 검색
        for(int i=0 ; i<clothes.length ; i++){
            String title = clothes[i][1];
            map.put(title,map.getOrDefault(title,0)+1);
        }

        //clothes의 행의 값을 가져와서 검색
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1],0)+1);
        }

        Iterator iter = map.values().iterator();
        int count = 1;
        while(iter.hasNext()){
            count *= (((int)iter.next())+1);
        }

        return count-1;
    }
}
