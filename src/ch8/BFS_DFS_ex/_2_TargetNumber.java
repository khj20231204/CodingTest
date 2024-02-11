package ch8.BFS_DFS_ex;

public class _2_TargetNumber {

    public int solution(int[] numbers, int target) {
        int sumCount(numbers, target, 0, 0);
    }

    int sumCount(int[] numbers, int target, int idx, int sum){

        if(idx >= numbers.length){
            if(sum == target) return 1;
            return 0;
        }

        return sumCount(numbers, target, idx+1, sum+numbers[idx])+sumCount(numbers, target, idx+1, sum-numbers[idx]);

    }
}
