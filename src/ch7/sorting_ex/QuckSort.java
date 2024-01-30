package ch7.sorting_ex;

import java.util.*;

public class QuckSort {
    static List<Integer> quickSort(List<Integer> list){
        //인덱스로 탐색하는 과정없이 바로 pivot과 값을 비교해서 덩어리로 나누고
        //나눈 덩어리를 다시 재귀로 원소 1개가 남을 때까지 계속 나눈다.

        if(list.size()<1) return list;

        int pivot = list.remove(0);

        List<Integer> lesser = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int i=0; i<list.size() ; i++){
            if(pivot > list.get(i)) lesser.add(list.get(i));
            else greater.add(list.get(i));
        }

        List<Integer> merge = new ArrayList<>();
        merge.addAll(quickSort(lesser));
        merge.add(pivot);
        merge.addAll(quickSort(greater));

        return merge;
    }
}
