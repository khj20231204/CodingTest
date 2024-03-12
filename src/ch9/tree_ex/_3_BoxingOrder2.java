package ch9.tree_ex;
import java.util.*;
public class _3_BoxingOrder2 {
   private class Node{
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

   //-------------------------------------


   private class Boxer{
      int v;
      boolean visited = false;
      int win = 0;
      int lose = 0;
      List<Boxer> list;


      public Boxer(int v){
         this.v = v;
         list = new ArrayList<>();
      }
   }


   public int solution2(int n, int[][] results) {

      //node생성
      List<Boxer> boxerList = new ArrayList<>(); //아무의미 없이 Boxer를 연결하기 위해 사용
      for(int i=0 ; i<n ; i++){
         boxerList.add(new Boxer(i+1)); //Boxer에 입력은 값으로
      }

      //연결
      for(int[] i : results){
         Boxer winner = boxerList.get(i[0]-1); //boxerList에서 불러올 땐 idx로
         Boxer loser = boxerList.get(i[1]-1);

         winner.list.add(loser); //연결만 되어 있으면 loser가 된다
      }

      //탐색
      for(Boxer winner : boxerList){
         //visited를 false로
         makeVisitedFalse2(boxerList);

         Queue<Boxer> q = new LinkedList<>();
         q.offer(winner);

         while(!q.isEmpty()){
            Boxer j = q.poll();
            System.out.println("winner.v:"+winner.v+" ,winner.win:"+winner.win+" ,winner.lose:"+winner.lose);
            for(Boxer i : j.list){
               if(i.visited) continue;

               winner.win += 1 ;
               i.lose += 1;
               i.visited = true;

               q.offer(i);
            }
         }

      }

      int answer = 0;
      for(Boxer b : boxerList){
         if(b.win+b.lose == (n-1)) answer++;
      }

      return answer;
   }

   void makeVisitedFalse2(List<Boxer> boxerList){
      for(Boxer b : boxerList){
         b.visited = false;
      }
   }
}
