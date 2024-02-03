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

        // solve #1
        int[] arr = {4,3,2,1};
        int[] result = _1_RemoveLeastNumber.solution2(arr);


        // solve #2
        List<Integer> list = new ArrayList<>();

        Random r = new Random();
        for(int i=0 ; i<20 ; i++){
            list.add(r.nextInt(30));
        }

        String[] strArray = {"abbcd","edefd","bdefea","ahef","gawd"};
        strArray = _2_MakeOrderAsIwant.solution4(strArray,1);
        //for(String s1 : strArray) System.out.print(s1+" ");


    }
}
