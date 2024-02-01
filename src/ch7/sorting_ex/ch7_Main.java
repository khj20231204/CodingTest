package ch7.sorting_ex;

import java.util.*;

class MyData implements Comparable{
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

public class ch7_Main {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();

        Random r = new Random();
        for(int i=0 ; i<20 ; i++){
            list.add(r.nextInt(30));
        }

        //List<Integer> result = QuckSort.quickSort(list);
        _1_RemoveLeastNumber.solution();

    }

    static void useSort(){
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
                return o1.compareTo(o2);
                //return o1-o2;
            }
        });

        //람다식 사용
        list.sort((o1,o2) -> o1.compareTo(o2));

        // ------------- MyData ------------------ //
        List<MyData> myDataList = new ArrayList<>();

        for(int i=0 ; i<20 ; i++){
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
