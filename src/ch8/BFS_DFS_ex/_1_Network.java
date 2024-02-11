package ch8.BFS_DFS_ex;

import java.util.*;

public class _1_Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] check = new boolean[computers[0].length];

        for(int i=0 ; i<computers.length ; i++){
            if(check[i]) continue;

            answer++;
            ss(computers, check, i);
        }

        return answer;
    }

    void ss(int[][] computers, boolean[] check, int i){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.println(tmp);

            for(int j=0 ; j<computers[tmp].length ; j++){
                if(check[i]) continue;
                if(computers[tmp][j] == 1) {
                    queue.offer(j);
                    check[j] = true;
                }
            }
        }
    }
}

