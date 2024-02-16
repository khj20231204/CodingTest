package ch9.tree_ex;
import java.util.*;
public class _2_MostFarNode {
   class Node{
      int num;
      boolean visited;
      List<Node> edge = new LinkedList<>();

      public Node(int n){
         num = n;
      }
   }

   public int solution(int n, int[][] edge) {
      int answer = 0;

      //노드를 인덱스로 리스트에 생성
      List<Node> nodeList = new ArrayList<>();
      for(int i=0 ; i<n ; i++){
         nodeList.add(new Node(i+1));
      }

      //노드끼리 연결
      for(int[] e : edge){
         Node n1 = nodeList.get(e[0]-1);
         Node n2 = nodeList.get(e[1]-1);

         n1.edge.add(n2);
         n2.edge.add(n1);
      }

      //탐색
      Queue<Node> q = new LinkedList<>();
      q.offer(nodeList.get(0));

      while(!q.isEmpty()){
         Node node = q.poll();
         //System.out.println(node.num);

         for(Node m : node.edge){
            System.out.println("m.num"+m.num+" ,m.visited:"+m.visited);
            /*
            * 1-2-4 와 1-2-5 이렇게 연결되어 있으면 2에서 visited가 true이면
            * 2까지 distance가 1로 증가된 상태에서
            * 4에서 distance+1로 2가 되고
            * 5에서 distance+1로 2가 된다.
            * visited가 true이면 queue에 offer하는 것과 distance카운트가 생략되고
            * node.edge에서 4와 5를 가져올 땐 각각의 노드에서 distance를 증가 시킨다
            */

            if(m.visited) continue;
            //System.out.println(m.num);

            m.visited = true;
            q.offer(m);

         }
      }

      return answer;
   }
}
