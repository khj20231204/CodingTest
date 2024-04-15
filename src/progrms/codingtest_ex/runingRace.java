package progrms.codingtest_ex;
import java.util.*;
public class runingRace {

   //---------------- 시간 초과 ------------------------------------
   class Player{
      String name;
      int level;

      public Player(String n){
         name = n;
      }

      public Player(String n, int l){
         name = n;
         level = l;
      }

      public String getName(){
         return name;
      }

      @Override
      public boolean equals(Object o){
         if(o instanceof Player){
            String n = ((Player)o).name;

            if(name.equals(n)) return true;
         }
         return false;
      }
   }

   public String[] solution1(String[] players, String[] callings) {

      List<Player> list = new LinkedList<>();
      for(int i=0 ; i<players.length ; i++){
         list.add(new Player(players[i],i));
      }

      for(int i=0 ; i<callings.length ; i++){
         //호출된 선수 name, level
         String name1 = callings[i];
         Player p1 = list.remove(list.indexOf(new Player(name1)));

         //호출된 선수의 앞 선수 name, level
         Player p2 = list.remove(p1.level-1);

         //호출된 선수 순위 증가 후 새로 입력
         list.add(p1.level-1, new Player(p1.name, p1.level-1));

         //호출된 선수의 앞 선수 순위 감소 후 새로 입력
         list.add(p2.level+1, new Player(p2.name, p2.level+1));
      }

      String[] answer = new String[players.length];

      int idx = 0;
      for(Player p : list){
         answer[idx++] = p.name;
      }

      return answer;
   }

   //---------------- 시간 초과 ------------------------------------
   public String[] solution2(String[] players, String[] callings) {

      String[] answer = new String[players.length];

      for (int i = 0; i < callings.length; i++) {
         String name = callings[i];

         for (int j = 0; j < players.length; j++) {

            if (players[j].equals(name)) {
               String tmp = players[j];
               players[j] = players[j - 1];
               players[j - 1] = tmp;
            }
         }
      }
      return players;
   }

   //---------------- 시간 초과 - reverse ------------------------------------
   public String[] solution3(String[] players, String[] callings) {

      List<String> list = Arrays.asList(players);

      for(String s : callings){
         int index = list.indexOf(s);
         Collections.reverse(list.subList(index-1, index+1));
      }

      return list.stream().toArray(String[]::new);
   }
}
