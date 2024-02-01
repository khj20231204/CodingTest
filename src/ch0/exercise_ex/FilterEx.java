package ch0.exercise_ex;

import java.util.*;

public class FilterEx {
    static void filterEx(){
        int[] intArray = {2,3,4,2};

        Integer[] integerArray = {8,5,7,5};

        List<Integer> integerList = new ArrayList<>();
        integerList.add(6);
        integerList.add(4);
        integerList.add(12);

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        //Arrays.stream(intArray).filter(i -> i.); //nothing
        //Arrays.stream(integerArray).filter(i -> i.) //compareTo, equals, hashCode, intValue,,,
        //integerList.stream().filter(i -> i.) //compareTo, equals, hashCode, intValue,,,
    }
}
