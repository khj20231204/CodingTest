package ch6.search_ex;

import java.util.*;

//search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있다. : 완전탐색
//equals 재정의

//이진탐색 : Collections.binarySearch
//Comparable 재정의
//순서대로 정렬되어 있어야 함

class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v){
        this.v = v;
    }

    public String toString(){
        return ""+v;
    }

    @Override
    public boolean equals(Object obj){
        int v_ = ((MyData)obj).v;
        System.out.println("obj v:"+v_);
        return this.v == v_;
    }

    @Override
    public int compareTo(MyData o) {
        //a와 b의 크기는 뺄셈으로 알 수 있다
        //a - b = 0 : 같다
        //a - b > 0 : a>b
        //a - b < 0 : a<b

        return v - o.v;
    }
}

public class ch6_Main {
    public static void main(String[] args){

        List<MyData> list = new LinkedList<>();
        Random r = new Random();

        for(int i=1 ; i<100 ; i++) {
            //list.add(new MyData(r.nextInt(100)));
            list.add(new MyData(i));
        }

        System.out.println(list);

        int index = Collections.binarySearch(list, new MyData(17));

        //int idx = list.indexOf(new MyData(13));
        System.out.println(index);

    }
}
