package ch8.BFS_DFS_ex;

import java.util.*;
public class BFS {

    public void bfs(){
        Nodes A = new Nodes("A");
        Nodes B = new Nodes("B");
        Nodes C = new Nodes("C");
        Nodes D = new Nodes("D");
        Nodes E = new Nodes("E");

        A.addNode(B);
        A.addNode(D);
        B.addNode(A);
        B.addNode(C);
        B.addNode(E);
        C.addNode(B);
        C.addNode(D);
        D.addNode(A);
        D.addNode(C);
        D.addNode(E);

        Queue<Nodes> queue = new LinkedList<>();
        queue.offer(A);

        Nodes target = E;
        while(!queue.isEmpty()){
            /*
           1)Queue에서 꺼내고
           2)break 조건 확인
           3)for문으로 연결된 노드 큐에 입력
            */
            Nodes q = queue.poll();
            q.setVisited();
            System.out.println(q.toString());

            if(q.equals(target)) break;

            //forEach(queue::offer)
            //q에 연결된 nodeList를 forEach를 사용해서 전부 queue에 offer한다
            q.nodeList.stream().filter(i -> !queue.contains(i) && !i.getVisited()).forEach(queue::offer);

        }
    }
    class Nodes{
        String name; //노드 자신 이름
        List<Nodes> nodeList; //연결된 노드 입력

        boolean visited = false;

        public Nodes(String name){
            this.name = name;
            nodeList = new ArrayList<>();
        }

        public void addNode(Nodes n){
            nodeList.add(n);
        }

        public void setVisited(){
            visited = true;
        }

        public boolean getVisited(){
            return visited;
        }

        @Override
        public boolean equals(Object obj) {
            return name.equals(((Nodes)obj).name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
