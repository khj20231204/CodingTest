package ch8.BFS_DFS_ex;
import java.util.*;
public class BFS3 {

   class Node{

      String v;
      boolean visited;

      List<Node> list;
      public Node(String v){
         this.v = v;
         list = new LinkedList<>();
      }

      public void addNode(Node n){
         list.add(n);
      }
   }
   public void bfs3(){
      Node A = new Node("A");
      Node B = new Node("B");
      Node C = new Node("C");
      Node D = new Node("D");
      Node E = new Node("E");

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

      Queue<Node> q = new LinkedList<>();
      q.offer(A);

      while(!q.isEmpty()){
         Node n = q.poll();

         for(Node n2 : n.list){

         }
      }
   }
}
