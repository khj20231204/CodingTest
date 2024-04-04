package ch9.tree_ex;
import java.util.*;
public class _2_MostFarNode {
   class Node{
      int count = 0;
      int v;
      boolean visited = false;
      List<Node> links = new LinkedList<>();
      public Node(int v){this.v = v;}
   }

   public int solution1(int n, int[][] edge) {

      int answer = 0;

      //노드 생성과 list에 입력 동시에
      List<Node> list = new ArrayList<>();
      for(int i=0 ; i<n ; i++){
         list.add(new Node(i+1)); //list에 입력은 값 1,2,3,...
      }

      //연결(주어진 배열을 돌면서 해당 값을 list에서 가져와서 가져온 값끼리 서로 연결)
      for(int[] e : edge){
         Node n1 = list.get(e[0]-1); //list에서 get으로 불러올 때는 idx 0,1,2,3,...
         Node n2 = list.get(e[1]-1);

         n1.links.add(n2);
         n2.links.add(n1);
      }

      //탐색
      Queue<Node> q = new LinkedList<>();
      q.offer(list.get(0));
      int maxLink = 0;

      while(!q.isEmpty()){
         Node node = q.poll();
         node.visited = true;
         for(Node m : node.links){
            if(m.visited) continue;

            m.count = node.count+1;
            if(maxLink < m.count) maxLink = m.count;
            q.offer(m); //m=3(x),2,6
         }
      }

      for(Node m : list){
         if(m.count >= maxLink) answer++;
      }
      return answer;
   }

   /*--------------------------------------------------*/

   class Nodes{
      int v;
      List<Nodes> list;
      boolean visited = false;
      boolean depthVisited = false;
      int depth = 0;

      Nodes(int v, int d){
         list = new LinkedList<>();
         this.v = v;
         depth = d;
      }
   }

   public int solution2(int n, int[][] edge) {
      /*
      방문visited랑 depthVisited랑 구분
      방문visited는 큐에서 꺼내고 실제 방문해서 연결된 노드들을 연결할 때를 방문visited
      해당 한개의 노드에서 for문으로 연결된 노드들을 가져와서 큐에 넣을 때
      큐에 넣는 순간 depth증가. depth는 앞 노드에서 1증가해서 1번만 입력된다.
      */

      /*
      * 1-2-4 와 1-2-5 이렇게 연결되어 있으면 2에서 depthVisited가 true이면
      * 2까지 distance가 1로 증가된 상태에서
      * 4에서 distance+1로 2가 되고
      * 5에서 distance+1로 2가 된다.
      * depthVisited가 true이면 queue에 offer하는 것과 distance카운트가 생략되고
      * node.edge에서 4와 5를 가져올 땐 각각의 노드에서 distance를 증가시킨다
      */

      //노드 생성
      List<Nodes> nodeList = new LinkedList<>();

      for(int i=0 ; i<n ; i++){
         Nodes node = new Nodes(i+1,0);
         if(i == 0) node.depthVisited = true;

         nodeList.add(node);
      }

      //연결
      for(int[] i : edge){
         Nodes node = nodeList.get(i[0]-1);
         Nodes node2 = nodeList.get(i[1]-1);

         node.list.add(node2);
         node2.list.add(node);
      }

      //탐색
      Queue<Nodes> q = new LinkedList<>();
      q.offer(nodeList.get(0));
      int max = 0;
      while(!q.isEmpty()){
         Nodes node = q.poll();

         if(node.visited) continue;
         node.visited = true;

         for(Nodes n2 : node.list){
            if(n2.depthVisited) continue;

            n2.depth = node.depth+1;
            if(max < n2.depth) max = n2.depth;
            n2.depthVisited = true;
            q.offer(n2);
         }
      }

      int answer = 0;
      for(Nodes no : nodeList){
         if(no.depth == max) answer++;
      }
      return answer;
   }
}
