package ch4.set_ex;

import java.util.ArrayList;

public class _3_HateSameNumber {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = -1; //-1이란 주어진 값보다 더 작은 값을 임의의 입력
        for(int i=0 ; i<arr.length ; i++){
            if(temp == arr[i]) continue;  //같으면 continue
            temp = arr[i];
            list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
