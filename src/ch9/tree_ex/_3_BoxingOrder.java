package ch9.tree_ex;

import java.util.*;
public class _3_BoxingOrder {

   class Node{
      int n;
      int win=0, lose=0;
      boolean visited = false;
      List<Node> links = new LinkedList<>();

      Node(int n){this.n = n;}
   }
   public int solution(int n, int[][] results) {
      List<Node> list = new ArrayList<>();
      for(int i=0 ; i<n ; i++) list.add(new Node(i+1));

      for(int[] result : results){
         Node winner = list.get(result[0]-1);
         Node loser = list.get(result[1]-1);

         winner.links.add(loser);
      }

      for(Node winner : list){
         for(Node node : list) {node.visited = false;}

         Queue<Node> queue = new LinkedList<>();
         winner.visited = true;
         queue.offer(winner);

         while(!queue.isEmpty()){
            Node now = queue.poll();

            for(Node loser : now.links){
               if(loser.visited) continue;
               loser.visited = true;

               winner.win += 1 ;
               loser.lose += 1;

               queue.offer(loser);
            }
         }
      }

      int answer = 0;
      for(Node node : list){
         if(node.win + node.lose == n-1) answer++;
      }

      return answer;
   }
}
