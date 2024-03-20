package ch5.stackqueue_ex;

import java.util.*;
/* 올림 계산 시 제수나 피제수를 float으로 변경  */

public class _2_FacilityDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        //1.(100-progress / speeds)를 올림한 결과 list
        //2.계산 결과 list를 배포하는 list
        //3.배포 list를 배열로 변경

        //1. (100-progress / speeds)를 올림한 결과 calList
        List<Integer> calList = new ArrayList<>();
        int cnt = 0;
        for(int i : progresses){
            float a = ((float)(100-i)/(float)speeds[cnt++]);
            int b = (int)Math.ceil(a);
            //System.out.println(b);
            calList.add(b);
        }

        //2. 배포 List 생성 - resultList
        //앞에서 수(head)가 더 크면 count를 증가 시키고, 더 작으면 count를 list에 입력 후 현재 값(next)을 head에 입력
        List<Integer> resultList = new ArrayList<>();
        int count = 1;
        int head = calList.remove(0); //최초 비교할 값 입력

        Iterator iter = calList.iterator();
        while(iter.hasNext()){
            int next = (int)iter.next();
            if(head >= next){ //앞에 수가 더 크면 count++;
                count++;
            }else{
                resultList.add(count);
                count = 1;
                head = next;
            }
        }
        resultList.add(count);

        //3. resultList를 배열로 변경
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        //queue를 이용

        //완료 날 계산
        Queue<Integer> queue = new LinkedList<>();
        int idx = 0;
        for(int i : progresses){
            float remainDayF = (100-i)/(float)speeds[idx++];
            queue.offer((int)Math.ceil(remainDayF));
        }

        //배포 날 카운트
        Queue<Integer> distriQueue = new LinkedList<>();
        int head = queue.poll();
        int count = 1;
        int max = queue.size();
        while(!queue.isEmpty()){
            int rear = queue.poll();

            if(head < rear){ //입력
                distriQueue.offer(count);
                count = 1;
                head = rear;
            }else {  //카운트 증가
                count++;
            }
        }
        distriQueue.offer(count);

        //리스트의 배포 날을 배열로 변환 후 리턴
        return distriQueue.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution3(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int count = 1;
        int tmp = (int)Math.ceil((100-progresses[0])/(float)speeds[0]);;
        for(int i=1 ; i<progresses.length ; i++){
            int v = (int)Math.ceil((100-progresses[i])/(float)speeds[i]);
            //앞에 수가 더 크면 count++
            if(tmp >= v){
                count++;
            }else{
                list.add(count);
                count=1;
                tmp = v;
            }
        }
        list.add(count);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
