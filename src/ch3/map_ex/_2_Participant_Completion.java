package ch3.map_ex;

import java.util.*;
public class _2_Participant_Completion {
    public String solution(String[] participant, String[] completion) {

        //1)map - 키값으로 이름을 넣게되면 중복으로 participant를 넣지 못 한다. 따라서 키값으로 이름을 넣고 value로 카운트를 한다
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant){
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for(String s : completion){
            int num = map.get(s) - 1;
            if(num == 0){
                map.remove(s);
            }else map.put(s,num);
        }
        //return map.keySet().iterator().next();

        //2)list
        ArrayList<String> list = new ArrayList<>();
        for(String s : participant){list.add(s);}
        //System.out.println(list);
        for(String s : completion){list.remove(s);}//<--- 효율성 초과
        //return list.get(0);

        //3)배열 정렬 후 제거
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0 ; i<completion.length ; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}
