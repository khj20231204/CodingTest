package ch9.tree_ex;

import java.util.*;

public class HeapEx {

    void heapEx(){
        Queue<Integer> heap = new PriorityQueue<>();
        Queue<Integer> heapReverse = new PriorityQueue<>(Comparator.reverseOrder());

        Random r = new Random();
        for(int i=0 ; i<5 ; i++){
            int tmp = r.nextInt(1,10);
            heap.offer(tmp);
            heapReverse.offer(tmp);
        }
        System.out.println(heap); //[2, 1, 4, 3, 6]

        List<Integer> list = new ArrayList<>();
        List<Integer> listReverse = new ArrayList<>();
        while (!heap.isEmpty()){
            list.add(heap.poll());
            listReverse.add(heapReverse.poll());
        }

        System.out.println(list); //[1, 2, 3, 4, 6]

        System.out.println(listReverse); //[6, 4, 3, 2, 1]
    }

    void heapUseMyData(){
        Queue<MyData> heap = new PriorityQueue<>();
        heap.offer(new MyData(8));
        heap.offer(new MyData(2));
        heap.offer(new MyData(4));
        heap.offer(new MyData(6));

        System.out.println(heap);

        List<MyData> list = new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(heap.poll());
        }

        System.out.println(list);
    }

    class MyData implements Comparable<MyData>{

        int v;

        public MyData(int v){ this.v = v;}

        @Override
        public String toString() {
            return String.valueOf(v);
        }

        @Override
        public int compareTo(MyData o) {
            return Integer.compare(v, o.v);
        }
    }

}
