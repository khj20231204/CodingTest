package progrms.codingtest_ex;
import java.util.*;

//가장 많이 받은 선물
public class mostGivenPresents {
   //클래스 - 준사람
   //클래스 안에서 map으로 받은사람과 관계
   //"A B"
   //클래스A를 찾아서 map에서 B를 찾아서 +1
   //클래스B를 찾아서 map에서 A를 찾아서 -1
   //map의 integer가 양수이면 다음 달에 받는 경우

   //선물지수 - map
   //

   class Friend{
      String name;
      Map<String, Integer> map = new HashMap<>();
      int presentNumber = 0;
      int result = 0;

      public Friend(String n){
         name = n;
      }

      public boolean equals(Object obj){
         if(obj instanceof Friend){
            String n = ((Friend)obj).name;

            if(name.equals(n)) return true;
         }
         return false;
      }

      public void plus(String s){ //준경우

         if(map.get(s) == null || map.get(s)==0){
            map.put(s,1);
         }else{
            map.replace(s, map.get(s)+1);
         }
      }

      public void minus(String s){ //받은경우
         if(map.get(s) == null || map.get(s)==0){
            map.put(s,-1);
         }else{
            map.replace(s, map.get(s)-1);
         }
      }

      public void plusPresentNumber(){
         presentNumber++;
      }

      public void minusPresentNumber(){
         presentNumber--;
      }
   }

   public int solution(String[] friends, String[] gifts) {
      int answer = 0;

      List<Friend> list = new ArrayList<>();
      for(String s : friends){
         list.add(new Friend(s));
      }

      for(String s : gifts){
         //주고 받은 선물 관계
         String[] names = s.split(" ");
         String giver = names[0];
         String receiver = names[1];

         Friend giverFriend = list.get(list.indexOf(new Friend(giver)));
         Friend receiverFriend = list.get(list.indexOf(new Friend(receiver)));

         //map의 Integer값이 양수이면 받을 게 있는 경우, 음수이면 신경 안 씀, 0이면 선물지수
         giverFriend.plus(receiver);
         receiverFriend.minus(giver);

         //선물지수
         giverFriend.plusPresentNumber();
         receiverFriend.minusPresentNumber();
      }

      for(Friend f : list){
         //map의 key에 contains로 확인 후 name이 있는 경우
         //양수이면 count++
         //없는 경우 선물지수로 count

         for(String s : friends){
            if(f.map.containsKey(s)){ //value가 양수이면 count++
               Iterator iter = f.map.values().iterator();
               while(iter.hasNext()){
                  int n = Integer.valueOf(iter.next().toString());
                  //System.out.println(iter.next());
                  if(n>0) f.result++;
               }
            }else{   //선물지수로 count
               int presentNum1 = f.presentNumber;
               int presentNum2 = (list.get(list.indexOf(new Friend(s)))).presentNumber;

               if(presentNum1 > presentNum2) f.result++;
            }
         }
      }

      for(Friend f : list){
         System.out.println(f.result);
      }

      return answer;
   }
}
