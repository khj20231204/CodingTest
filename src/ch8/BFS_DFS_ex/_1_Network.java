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

            for(int j=0 ; j<computers[i].length ; j++){
                if(visited[j]) continue;

                if(computers[i][j] == 1) {
                    q.offer(j);
                    visited[j] = true; //큐에 offer할 때 visited를 true로 한다
                }
            }
        }
    }

    public int solution2(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i=0 ; i<n ; i++){
            if(visited[i]) continue;
            //visited[i] = true;
            answer++;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()){
                int t = q.poll();

                for(int j=0 ; j<computers[t].length ; j++){
                    if(visited[j]) continue;

                    if(computers[t][j] == 1){
                        q.offer(j);
                        visited[j] = true;
                    }

                }
            }
        }
        return answer;
    }

    public int solution3(int n, int[][] computers) {
        int answer = 0;

        //노드 생성
        List<Nodes> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            list.add(new Nodes(i+1));
        }

        //노드 연결
        for(int i=0 ; i<computers.length ; i++){
            Nodes node = list.get(i);

            for(int j=0 ; j<computers[i].length ; j++){
                if(computers[i][j] == 1){

                    node.next.add(list.get(j));
                }
            }
        }

        //순회
        Queue<Nodes> queue = new LinkedList<>();

        for(Nodes origin : list){
            if(origin.visited) continue;
            queue.offer(origin);
            answer++;

            while(!queue.isEmpty()){
                Nodes node = queue.poll();

                for(Nodes node2 : node.next){
                    if(!node2.visited){
                        node2.visited = true;
                        queue.add(node2);
                    }
                }
            }
        }
        return answer;
    }
    class Nodes{
        int v;
        boolean visited = false;
        List<Nodes> next;

        public Nodes(int v){
            this.v = v;
            next = new LinkedList<>();
        }
    }
}

