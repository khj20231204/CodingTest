package ch7.sorting_ex;

import java.util.*;

public class _1_RemoveLeastNumber {
    public void solution(){
        int[] a = {2,3,4,2};

        int[] b = Arrays.stream(a).filter(Arrays.stream(a).min().getAsInt()).forEach(System.out::println);
    }
}
