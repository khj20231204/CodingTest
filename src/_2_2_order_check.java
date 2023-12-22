/*
길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
arr	result
[4, 1, 3, 2] true
[4, 1, 3]	false
 */

import java.util.*;
import java.util.stream.*;

public class _2_2_order_check {
    public boolean solution1(int[] arr){
        boolean answer = true;

        int len = arr.length;
        System.out.println(len);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for(int i=1 ; i<=len ; i++)
            if(!list.contains(i))
                answer = false;

        return answer;
    }

    public boolean solution2(int[] arr){
        boolean answer = true;

        int len = arr.length;
        Arrays.sort(arr);

        for(int i=0 ; i<len ; i++) {
            if(arr[i] != i+1){
                answer = false;
                break;
            }
        }

        return answer;
    }

    public boolean solution3(int[] arr){
        boolean answer = true;

        int[] arr2 = new int[arr.length];

        for(int i=0 ; i<arr.length ; i++){
            arr2[i] = i+1;
        }

        Arrays.sort(arr);

        return Arrays.equals(arr, arr2);
    }

}
