package ch8.BFS_DFS_ex;

import java.util.*;
public class BFS3 {
   class Node{
      String name;
      boolean visied;
      List<Node> list;
      boolean target = false;
      public Node(String n){
         name = n;
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

      Queue<Node> q = new LinkedList<>();
      q.offer(A);

      while(!q.isEmpty()){
         Node n = q.poll();
         n.visied = true;
         System.out.println(n.name);
         if(n.target) {
            System.out.println("Found!!");
            break;
         }

         for(Node n2 : n.list){
            if(n2.visied) continue;
            q.offer(n2);
         }
      }
      //queue에서 값을 가져오기

      //조건문 검색

      //for문으로 queue에 데이터 입력


   }
}
