package ch8.BFS_DFS_ex;

import java.util.*;

public class _1_Network {

    public int solution(int n, int[][] computers) {
        //최초방문시 answer증가
        //방문 후 연결된 node전부 visited = true
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            answer++;
            allConnected(computers, visited, i);
        }
        return answer;
    }

    void allConnected(int[][] computers, boolean[] visited, int c){
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while(!q.isEmpty()) {
            int i = q.poll();
            visited[i] = true;
            for (int j = 0; j < computers[i].length; j++) {
                if (visited[j]) continue;
                if (computers[i][j] == 1) q.offer(j);
            }
        }
    }
}
