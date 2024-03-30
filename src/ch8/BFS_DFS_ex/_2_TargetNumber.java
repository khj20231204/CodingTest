package ch8.BFS_DFS_ex;
import java.util.*;
public class _2_TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = sumCount(numbers, target, 0, 0);

        return answer;
    }

    int sumCount(int[] numbers, int target, int idx, int sum){

        if(idx >= numbers.length){
            if(sum == target) return 1;
            return 0;
        }

        return sumCount(numbers, target, idx+1, sum+numbers[idx])
                + sumCount(numbers, target, idx+1, sum-numbers[idx]);
    }

    //------------------ 클래스 이용 -------------------
    class Number {

        int idx, sum;

        public Number(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }


}
