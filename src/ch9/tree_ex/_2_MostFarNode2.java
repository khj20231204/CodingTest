package ch9.tree_ex;
import java.util.*;
public class _2_MostFarNode2 {

   private class Node{
      int v;
      int depth = 0;
      boolean visited = false;
      boolean depthVisited = false;
      List<Node> list;

      public Node(int v){
         this.v = v;
         list = new LinkedList<>();
      }
   }

   public int solutionError(int n, int[][] edge) {

      List<Node> nodeList = new LinkedList<>();

      //노드 생성
      for(int i=1 ; i<=n ; i++){
         nodeList.add(new Node(i));
      }

      //연결
      for(int[] i : edge){
         Node node1 = nodeList.get(i[0]-1); //list에 들어있는 건 idx값, i[0]은 value
         Node node2 = nodeList.get(i[1]-1);
         System.out.println("node1.v:"+node1.v+" ,node2.v:"+node2.v);
         node1.list.add(node2);
         node2.list.add(node1);
      }

      //탐색
      Queue<Node> q = new LinkedList<>();
      Node one = nodeList.get(0);
      one.depthVisited = true;
      q.offer(one);
      int max = 0;
      while(!q.isEmpty()){
         Node node = q.poll();

         if(node.visited) continue;
         node.visited = true;

         for(Node t : node.list){
            if(!t.depthVisited) {
               t.depth = node.depth+1;
            }
            t.depthVisited = true;
            if(t.depth > max) max=t.depth;

            q.offer(t);
         }
      }

      int answer = 0;

      for(Node t : nodeList){
         System.out.println("second t.depth:"+t.depth);
         if(t.depth == max) answer++;
      }

      return answer;
   }
}
