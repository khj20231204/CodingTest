package ch8.BFS_DFS_ex;

public class _2_TargetNumber {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        return sumCount(numbers, target, 0, 0);
    }

    int sumCount(int[] numbers, int target, int i, int sum){
        if(i == numbers.length) {
            if(sum == target) return 1;
            return 0;
        }
        return sumCount(numbers, target, i+1, sum+numbers[i]) +
                sumCount(numbers, target, i+1, sum-numbers[i]);
    }
}
