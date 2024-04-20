package progrms.codingtest_ex;

public class ParkWalk {
   public int[] solution(String[] park, String[] routes) {
      int[] answer = {};
      //park -> char[][]
      //N : char[감소][]
      //S : char[증가][]
      //W : char[][감소]
      //E : char[][증가]

      int H = 0;
      int W = 0;
      char[][] parkArray = new char[park.length][park[0].length()];
      for(int i=0 ; i<park.length ;i++){
         for(int j=0 ; j<park[i].length() ; j++){
            parkArray[i][j] = park[i].charAt(j);
            if(parkArray[i][j] == 'S'){
               H = i;
               W = j;
            }
         }
      }

      char[][] routesArray = new char[routes.length][routes[0].length()];
      for(int i=0 ; i<routes.length ; i++){
         for(int j=0 ; j<routes[i].length() ; j++){
            routesArray[i][j] = routes[i].charAt(j);
         }
      }

      for(int i=0 ; i<routesArray.length ; i++){
         //방향 N,S,W,E
         char direction = routesArray[i][0];
         //이동 횟수
         int moveCount = Character.getNumericValue(routesArray[i][2]);
         //'X'인지 확인
         boolean check = true;

         if(direction == 'N'){
            if(H-moveCount<0) continue;
            for(int k=0 ; k <= moveCount ; k++){
               if(parkArray[H-k][W] == 'X') check = false;
            }

            //char[감소][]
            if(check) H -= moveCount;
         }else if(direction == 'S'){
            if(H+moveCount >= parkArray.length) continue;
            for(int k=0 ; k <= moveCount ; k++){
               if(parkArray[H+k][W] == 'X') check = false;
            }

            ///char[증가][]
            if(check) H += moveCount;
         }else if(direction == 'W'){
            if(W-moveCount<0) continue;
            for(int k=0 ; k <= moveCount ; k++){
               if(parkArray[H][W-k] == 'X') check = false;
            }

            //W : char[][감소]
            if(check) W -= moveCount;
         }else{  //E
            if(W+moveCount>=parkArray[0].length) continue;
            for(int k=0 ; k <= moveCount ; k++){
               if(parkArray[H][W+k] == 'X') check = false;
            }

            //E : char[][증가]
            if(check) W += moveCount;
         }
      }

      return new int[]{H,W};
   }
}
