package ch6.search_ex;

import java.util.*;

class MyData implements Comparable<MyData>{
    int v;
    public MyData(int v){
        this.v = v;
    }
    @Override
    public String toString(){
        return ""+v;
    }
    @Override
    public int compareTo(MyData o) {  //Comparable의 구현 메소드
        return v - o.v;  //A와 B의 대소비교는 A-B로 빼서 비교가 가능
        //return Integer.compare(this.v, o.v);
    }
    @Override
    public boolean equals(Object o){
        return v == ((MyData)o).v;
    }
}

public class BinarySearchLibrary {
    public void binarySearchLibrary(){
        //binarySearch를 이용해서 MyData검색
        List<MyData> list = new LinkedList<>();

        Random r = new Random();
        for(int i=1 ; i<50 ; i++) list.add(new MyData(r.nextInt(i)));

        int idx = Collections.binarySearch(list, new MyData(32));
    }
}

