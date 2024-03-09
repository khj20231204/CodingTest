package ch9.tree_ex;
import java.util.*;
public class _3_BoxingOrder2 {

   class Node{
      int v;
      boolean visited = false;
      int win = 0;
      int lose = 0;
      List<Node> list;

      Node(int v){
         this.v = v;

         list = new LinkedList<>();
      }
   }

   public int solution(int n, int[][] results) {
      int answer = 0;

      //노드 생성
      List<Node> list = new LinkedList<>();
      for(int i=0 ; i<n ; i++){
         list.add(new Node(i+1));
      }

      //연결
      for(int[] i : results){
         int win = i[0];
         int lose = i[1];

         Node nodeWin = list.get(win-1);
         Node nodeLose = list.get(lose-1);

         nodeWin.list.add(nodeLose);
      }

      //탐색
      Queue<Node> q = new LinkedList<>();
      for(Node now : list){
         makeQueueEmpty(q);
         makeVisitedFalse(list);

         q.offer(now);
         while(!q.isEmpty()){
            Node node = q.poll();
            if(node.visited) continue;
            node.visited = true;
            //System.out.println("v:"+now.v+" ,win:"+now.win+" ,lose:"+now.lose);

            for(Node no : node.list){
               if(no.visited) continue;
               now.win++;
               no.lose++;
               System.out.println("now.v:"+now.v+" ,win:"+now.win+" ,lose:"+now.lose+" ,no.v:"+no.v+" ,no.lose:"+no.lose);

               q.offer(no);

            }
         }
      }

      for(Node no : list){
         //System.out.println("v:"+no.v+" ,win:"+no.win+" ,lose:"+no.lose);
      }

      return answer;
   }

   void makeQueueEmpty(Queue<Node> q){
      while(!q.isEmpty()){
         q.poll();
      }
   }

   void makeVisitedFalse(List<Node> list){
      for(Node no : list) no.visited = false;
   }
}
