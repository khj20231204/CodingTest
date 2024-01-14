package ch3.map_ex;

import java.util.*;

public class _1_Poketmon_count {

    public int solution(int[] nums) {

        int numsLen = nums.length/2;

        //1)map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(Integer.valueOf(i),0);
        }
        //return (numsLen > map.size() ? map.size() : numsLen);

        //2)list
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums){
            if(!list.contains(Integer.valueOf(i))){
                list.add(i);
            }
        }
        //return (numsLen > list.size() ? list.size() : numsLen);

        //3)array - 2중 반복문
        int count = 1;
        boolean check = true;
        for(int i=1 ; i<nums.length ; i++){
            check = true;
            for(int j=0 ; j<i ; j++){
                if(nums[i] == nums[j]) check = false;
            }
            if(check) count++;
        }
        //return (numsLen > count ? count : numsLen);

        //4)stream 이용
        int result = (int)Arrays.stream(nums).distinct().count();
        return (numsLen > result ? result : numsLen);
    }
}
