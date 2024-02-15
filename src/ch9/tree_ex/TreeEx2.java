package ch9.tree_ex;

import java.util.*;

public class TreeEx2 {
    void treeEx2(){
        //hashSet treeSet
        Set<MyData> treeMyData = new TreeSet<>();
        treeMyData.add(new MyData(4));
        treeMyData.add(new MyData(5));
        treeMyData.add(new MyData(4));
        treeMyData.add(new MyData(5));

        System.out.println(treeMyData);
    }


    private class MyData implements Comparable<MyData>{
        int v;

        @Override
        public String toString() {
            return String.valueOf(v);
        }

        public MyData(int v){
            this.v = v;
        }

        @Override
        public int compareTo(MyData o) {
            return Integer.compare(v, o.v);
        }
    }
}
