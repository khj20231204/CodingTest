package ch7.sorting_ex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class UseSorting {
    private class MyData implements Comparable{
        int v;
        public MyData(int v){
            this.v = v;
        }

        public String toString(){
            //return "" + v;
            return String.valueOf(v);
        }
        @Override
        public int compareTo(Object o) {
            //return ((MyData)o).v - this.v;
            //return this.v - ((MyData)o).v;
            return Integer.compare(v, ((MyData)o).v);
        }
    }

    void useSort(){
        // ------------- 숫자 정렬 ------------------ //
        List<Integer> list = new ArrayList<>();

        Random r = new Random();
        for(int i=0 ; i<20 ; i++){
            list.add(r.nextInt(30));
        }

        //Comparator이용
        list.sort(Comparator.reverseOrder());
        list.sort(Comparator.naturalOrder());

        //Comparator 익명객체 사용
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.intValue() - o2.intValue();
                return o1.compareTo(o2);
                //o1이 compareTo를 사용하기 위해선
                //인자 (Integer o1,..) 에서 Integer가 comparable을 extends해야 한다
                //실제 Integer는 comparable을 상속 받았다
            }
        });

        //람다식 사용
        list.sort((o1,o2) -> o1.compareTo(o2));

        // ------------- MyData ------------------ //
        List<MyData> myDataList = new ArrayList<>();

        for(int i=0 ; i<20 ; i++){
            myDataList.add(new MyData(r.nextInt(30)));
            myDataList.add(new MyData(r.nextInt(30)));
        }

        myDataList.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });

        //myDataList.sort(Comparator.naturalOrder());
        myDataList.sort(Comparator.reverseOrder());
        //Comparator에서 사용하는 건 compare인데 compare에서 Object를 비교하기 위해서 사용하는건
        //compareTo기 때문에 compareTo로 비교할 수 있으면 사용 가능
        //compareTo를 재정의 하기위해서 comparable를 상속
        System.out.println(myDataList);
    }
}
