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
   class Node2{
      int count = 0;
      int v;
      boolean visited = false;
      List<Node2> links = new LinkedList<>();
      public Node2(int v){this.v = v;}
   }

   public int solution2(int n, int[][] edge) {
      int answer = 0;

      //노드 생성과 list에 입력 동시에
      List<Node2> list = new ArrayList<>();
      for(int i=0 ; i<n ; i++){
         list.add(new Node2(i+1)); //list에 입력은 값 1,2,3,...
      }

      //연결(주어진 배열을 돌면서 해당 값을 list에서 가져와서 가져온 값끼리 서로 연결)
      for(int[] e : edge){
         Node2 n1 = list.get(e[0]-1); //list에서 get으로 불러올 때는 idx 0,1,2,3,...
         Node2 n2 = list.get(e[1]-1);

         n1.links.add(n2);
         n2.links.add(n1);
      }

      //탐색
      Queue<Node2> q = new LinkedList<>();
      q.offer(list.get(0));
      System.out.println("list.get(0).v:"+list.get(0).v);
      int maxLink = 0;
      while(!q.isEmpty()){
         Node2 node = q.poll();
         System.out.println("q.poll():"+node.v);
         node.visited = true;
         for(Node2 m : node.links){
            if(m.visited) continue;

            System.out.println("m.v:"+m.v);
            m.count = node.count+1;
            System.out.println("m.count:"+m.count);
            if(maxLink < m.count) maxLink = m.count;
            System.out.println("maxLink:"+maxLink);
            q.offer(m); //m=3(x),2,6
         }
      }

      for(Node2 m : list){

         if(m.count >= maxLink) answer++;
      }
      return answer;
   }

   class Node3{
      int v;
      boolean visited = false;
      int depth = 0;
      List<Node3> line = new LinkedList<>();
      public Node3(int v){this.v = v;}
   }

   public int solution3(int n, int[][] edge) {
      int answer = 0;

      List<Node3> list = new ArrayList<>();
      for(int i=0 ; i<n ; i++){
         list.add(new Node3(i+1));
      }

      for(int[] i : edge){
         Node3 n1 = list.get(i[0]-1);
         Node3 n2 = list.get(i[1]-1);

         n1.line.add(n2);
         n2.line.add(n1);
      }

      //탐색
      Node3 one = list.get(0);
      one.visited = true;
      Queue<Node3> q = new LinkedList<>();
      q.offer(one);
      int maxDepth = 0;

      while(!q.isEmpty()){
         Node3 node = q.poll();
         //1) node.depth++;
         for(Node3 m : node.line){
            if(m.visited) continue;

            m.visited = true;
            //2)
            m.depth = node.depth+1;
            System.out.println("m.v:"+m.v+" ,m.depth:"+m.depth);
            if(m.depth > maxDepth) maxDepth = m.depth;
            q.offer(m);
         }
      }

      for(Node3 m : list){
         if(m.depth == maxDepth) answer++;
      }

      return answer;
   }
}
