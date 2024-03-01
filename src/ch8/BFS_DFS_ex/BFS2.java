package ch8.BFS_DFS_ex;

import algorithm_ex.PowerRecursive;

import java.util.*;

public class BFS2 {

   class Node{
      List<Node> addNode;
      String v;

      boolean target;
      boolean visited;

      public Node(String v){
         this.v = v;
         addNode = new ArrayList<>();
      }

      public void addNode(Node n){
         addNode.add(n);
      }
   }

   public void bfs2(){

      Node A = new Node("A");
      Node B = new Node("B");
      Node C = new Node("C");
      Node D = new Node("D");
      Node E = new Node("E");
      Node F = new Node("F");

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

      E.target = true;

      Queue<Node> queue = new LinkedList<>();
      queue.offer(A);

      while(!queue.isEmpty()){
         Node n = queue.poll();
         System.out.println("v:"+n.v);
         n.visited = true;
         if(n.target) {
            System.out.println("!!Found:"+n.v);
            break;
         }

         for(Node n2 : n.addNode){
            if(n2.visited) continue;
            if(queue.contains(n2)) continue;

            queue.offer(n2);
         }
      }
   }
}
