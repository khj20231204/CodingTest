package ch5.stackqueue_ex;

import java.util.*;

public class _4_Print {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        //location인지 아닌지 확인하기 위해서 클래스를 만든다

        List<CheckNumber> list = new ArrayList<>();

        for(int i=0 ; i<priorities.length ; i++){
            /*
            if(i == location) list.add(new CheckNumber(priorities[i],true));
            else list.add(new CheckNumber(priorities[i],false));
            */
            list.add(new CheckNumber(priorities[i],i == location));
        }

        //우선순위가 가장 높은 곳에서부터 확인하고, 다음 걸 찾아서 확인하고,.. 이게 아니라
        //값을 출력 후 비교하고 다시 입력, 출력 후 입력, 출력 후 입력,..



        //System.out.println(list);


        return answer;
    }

    class CheckNumber{
        int number;
        boolean check;

        public CheckNumber(int n, boolean c){
            number = n;
            check = c;
        }

        public boolean getCheck(){
            return check;
        }

        public int getNumber(){
            return number;
        }

        @Override
        public String toString(){
            return "["+ number +", "+ check + "]";
        }
    }
}
