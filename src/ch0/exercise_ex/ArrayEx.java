package ch0.exercise_ex;

import java.util.*;

public class ArrayEx {
    static void arrayEx(){
        int[] intArray = {2,3,4,2};

        Integer[] integerArray = {8,5,7,5};

        List<Integer> integerList = new ArrayList<>();
        integerList.add(6);
        integerList.add(4);
        integerList.add(12);

        //max, min은 int형 일때 구할 수 있고 반환 타입은 Optional
        int minIntArray = Arrays.stream(intArray).min().getAsInt(); //getAsInt()로 int형으로 변환]
        int minIntegerArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).min().getAsInt();
        int minIntegerList = integerList.stream().mapToInt(Integer::intValue).min().getAsInt();

        System.out.println("minIntArray:"+minIntArray+" ,minIntegerArray:"+minIntegerArray+" ,minIntegerList:"+minIntegerList);
        //minIntArray:2 ,minIntegerArray:5 ,minIntegerList:4

        Arrays.sort(integerArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1:"+o1+" ,o2:"+o2);
                if(o1 > o2) return 1;
                else if(o1 < o2) return -1;
                else return 0;
            }
        });

        for(int i : integerArray) System.out.println(i);
    }
}
