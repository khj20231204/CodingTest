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
            /*
            q에서 가져온 걸 visited로 거르는데 이 부분이 없으면 정상 동작한다
            if(node.visited) continue;
            node.visited = true;
            탐색할 때 visited로 거를지, 아니면 밑에 for문에서 큐에 offer할 때
            visited로 거를지, 아니면 두 군데 전부 거를지 판단해야 한다.
            */

            for(Node no : node.list){
               if(no.visited) continue;
               no.visited = true;
               now.win++;
               no.lose++;

               q.offer(no);
            }
         }
      }

      for(Node no : list){
         if((no.win + no.lose) == (n-1)) answer++;
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
