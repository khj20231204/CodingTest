package ch8.BFS_DFS_ex;

import java.util.*;

public class _1_Network {
    public int solution(int n, int[][] computers) {

        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0 ; i<computers[0].length ; i++){
            if(visited[i]) continue;
            answer++;
            allSearch(computers, visited, i);
        }
        return answer;
    }

    void allSearch(int[][] computers, boolean[] visited, int i){
        Queue<Integer> q = new LinkedList<>();

        q.offer(i);

        while(!q.isEmpty()){
            i = q.poll();

            visited[i] = true;
            for(int j=0 ; j<computers[i].length ; j++){
                if(visited[j]) continue;

                if(computers[i][j] == 1) q.offer(j);
            }
        }
    }
}

