package ch9.tree_ex;

import java.util.*;
public class _3_BoxingOrder {

   class Node{
      int v;
      int win = 0;
      int lose = 0;
      boolean visited = false;
      List<Node> link = new LinkedList<>();

      public Node(int v){
         this.v = v;
      }

      @Override
      public String toString(){
         return "v:"+v+" ,link.size():"+link.size()+" ,win:"+win +" ,lose:"+lose;
      }
   }

   public int solution(int n, int[][] results) {
      int answer = 0;

      List<Node> list = new LinkedList<>();
      for(int i=0 ; i<n ; i++){
         list.add(new Node(i+1));
      }

      for(int[] r : results){
         Node n1 = list.get(r[0]-1);
         Node n2 = list.get(r[1]-1);

         n1.link.add(n2);
      }

      //System.out.println(list.toString());

      for(Node node : list){
         Queue<Node> q = new LinkedList<>();
         for(Node m : list) m.visited = false;

         q.offer(node);

         while(!q.isEmpty()){
            Node tmp = q.poll();

            for(Node tmpLink : tmp.link){

               if(tmpLink.visited) continue;

               node.win++;
               tmpLink.lose++;
               tmpLink.visited = true;

               q.offer(tmpLink);
            }
         }
      }

      System.out.println(list.toString());

      for(Node node : list){
         int sum = node.win+node.lose;
         if(sum == n-1) answer++;
      }

      return answer;
   }
}
