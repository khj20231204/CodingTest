package progrms.codingtest_ex;

public class ParkWalk {

   public int[] solution(String[] park, String[] routes) {
      int[] answer = {};
      //park -> char[][]
      //N : char[감소][]
      //S : char[증가][]
      //W : char[][감소]
      //E : char[][증가]

      char[][] parkArray = new char[park.length][park[0].length()];
      for(int i=0 ; i<park.length ;i++){
         for(int j=0 ; j<park[i].length() ; j++){
            parkArray[i][j] = park[i].charAt(j);
            if(parkArray[i][j] == 'S'){

            }
         }
      }

      char[][] routesArray = new char[routes.length][routes[0].length()];
      for(int i=0 ; i<routes.length ; i++){
         for(int j=0 ; j<routes[i].length() ; j++){
            routesArray[i][j] = routes[i].charAt(j);
            System.out.println(routesArray[i][j]);
         }
      }

      int start = 0;
      return answer;
   }
}
