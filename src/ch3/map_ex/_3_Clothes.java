package ch3.map_ex;
import java.util.*;
public class _3_Clothes {
    public int solution1(String[][] clothes) {

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

    class Cloth{
        String title;
        int count=1;

        public Cloth(String t){title = t;}

        public String toString(){
            return "title:"+title+" ,count:"+count;
        }

        public boolean equals(Object o){
            return title.equals(((Cloth)o).title);
        }
    }

    public int solution2(String[][] clothes) {

        List<Cloth> list = new ArrayList<>();

        for(String[] s : clothes){

            if(list.contains(new Cloth(s[1]))){
                int idx = list.indexOf(new Cloth(s[1]));
                Cloth c = list.get(idx);
                c.count = c.count+1;
                continue;
            }

            list.add(new Cloth(s[1]));
        }

        int answer = 1;
        if(list.size() == 1) {
            answer = (list.get(0)).count;
        }else{
            for(Cloth c : list){
                answer *= (c.count+1);
            }
            answer--;
        }

        return answer;
    }

    public int solution3(String[][] clothes) {
        int answer = 1;

        Map<String,Integer> map = new HashMap<>();
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1],0)+1);
        }

        if(map.size() == 1){
            return map.values().iterator().next();
        }else{
            Iterator<Integer> iter = map.values().iterator();
            while(iter.hasNext()){
                answer *= iter.next()+1;
            }
        }

        return answer-1;
    }
}
