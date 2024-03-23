package ch5.stackqueue_ex;

import java.util.*;

public class _4_Print {
    public static int solution1(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // priorities 값
        for (int i : priorities) {
            queue.offer(i);
        }
        //queue는 peek()나 poll()이 될 때, 오름차순이나 내림차순, 정렬된 순서로 출력이 된다.
        //queue 자체의 순서는 입력된 순서와 일치하고 입력된 순서가 location과 일치
        //즉, queue의 데이터 입력 순서 = location.
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {  //priorities와 queue를 비교
                    if (location == i) { //priorities의 인덱스인 location과 i를 비
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }

    public int solutionUseClass(int[] priorities, int location) {

        //우선순위가 가장 높은 곳에서부터 확인하고, 다음 걸 찾아서 확인하고,.. 이게 아니라
        //값을 출력 후 비교하고 다시 입력, 출력 후 입력, 출력 후 입력,..

        List<MyData> list = new ArrayList<>();
        for(int i=0 ; i<priorities.length ; i++){
            list.add(new MyData(priorities[i], location == i));
        }

        //list에서 MyData를 꺼내면서 우선순위가 높은 게 있으면 다시 입력,
        //없으면 출력, location이 true이면 break;
        int count = 1;
        while(!list.isEmpty()){
            MyData data = list.remove(0);
            int tmp = data.getProc();
            boolean check = false; //더 높은 우선순위가 없다

            for(MyData m : list){
                if(tmp < m.getProc()){ //더 높은 우선순위가 있다
                    check = true;
                    break;
                }
            }

            if(check) { //더 높은 우선순위가 있어서 다시 입력
                list.add(data);
            }else {
                if(data.getLoc()) { //location이 일치하면 반복문을 멈춘다
                    break;
                }else{
                    count++;  //출력이니깐 count증가
                }
            }
        }
        return count;
    }
}

class MyData{
    int process;
    boolean location;

    public MyData(int p, boolean l){
        process = p;
        location = l;
    }
    public int getProc(){
        return process;
    }
    public boolean getLoc(){
        return location;
    }
    @Override
    public String toString(){
        String str = "process:" + process + " ,location:"+ location;
        return str;
    }

    class ReserveQ{
        int value;
        boolean target;

        public ReserveQ(int v, boolean t){
            this.value = v;
            this.target = t;
        }

        public String toString(){
            return "value:"+value+" ,target:"+target;
        }
    }

    public int solution3(int[] priorities, int location) {

        Queue<ReserveQ> q = new LinkedList<>();

        int cnt = 0;
        for(int i : priorities){
            q.offer(new ReserveQ(i, cnt == location));
            cnt++;
        }

        //System.out.println(q);

        int answer = 1;
        while(!q.isEmpty()){

            //최대값구하기
            int max = getMax(q);

            ReserveQ rq = q.poll();

            //최대값이면서 타켓이면 리턴
            if(rq.value==max && rq.target) return answer;

                //최대값이면 poll하고 answer증가
            else if(rq.value==max) answer++;

                //최대값보다 작으면 offer
            else q.offer(rq);
        }

        return answer;
    }

    int getMax(Queue<ReserveQ> q){

        int max = 0;
        for(ReserveQ r : q){
            if(max < r.value) max = r.value;
        }

        return max;
    }
}
