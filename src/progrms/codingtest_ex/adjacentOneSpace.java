package progrms.codingtest_ex;

public class adjacentOneSpace {
   public int solution(String[][] board, int h, int w) {
      int answer = 0;

      int bottom = board.length-1;
      int right = board[0].length-1;

      String color = board[h][w];

      //top
      if(h-1 >= 0){
         if(color.equals(board[h-1][w])) answer++;
      }

      //left
      if(w-1 >= 0){
         if(color.equals(board[h][w-1])) answer++;
      }

      //bottom
      if(h+1 <= bottom){
         if(color.equals(board[h+1][w])) answer++;
      }

      //right
      if(w+1 <= right){
         if(color.equals(board[h][w+1])) answer++;
      }

      return answer;
   }
}
