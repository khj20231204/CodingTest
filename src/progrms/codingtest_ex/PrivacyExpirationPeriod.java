package progrms.codingtest_ex;
import java.util.*;

public class PrivacyExpirationPeriod {
   public int[] solution(String today, String[] terms, String[] privacies) {
      int[] answer = {};

      //terms는 set에 저장
      Map<String, Integer> termsMap = new HashMap<>();
      for(String s : terms){
         String[] termsArr = s.split(" ");
         termsMap.put(termsArr[0], Integer.valueOf(termsArr[1]));
      }

      String[] todayArrStr = today.split("\\.");
      int[] todayIntArry = Arrays.stream(todayArrStr).mapToInt(Integer::valueOf).toArray();
      int today_year = todayIntArry[0];
      int today_month = todayIntArry[1];
      int today_day = todayIntArry[2];

      List<Integer> list = new ArrayList<>();
      for(int i=0 ; i<privacies.length ; i++){
         String s1 = privacies[i];

         String[] privacy = s1.split(" ");
         String[] date = privacy[0].split("\\."); //2021 05 02
         int[] dateInt = Arrays.stream(date).mapToInt(Integer::valueOf).toArray();
         int year = dateInt[0];
         int month = dateInt[1];
         int day = dateInt[2];

         String type = privacy[1]; //A B
         int addMonth = termsMap.get(type);

         ////유효기간 만들기
         //유효기간 month 더하기
         month += addMonth;
         if(month > 12){
            year++;
            month -= 12;
         }
         //day에서 1빼기
         day--;
         if(day < 1){
            day = 28;
            month--;
            if(month < 1){
               month = 12;
               year--;
            }
         }

         //약관날짜와 비교
         boolean check = false;
         if(year < today_year){
            check = true;
         }

         if(year == today_year && month < today_month){
            check = true;
         }

         if(year == today_year && month == today_month && day < today_day){
            check = true;
         }

         if(check) list.add(i+1);

      }

      return list.stream().mapToInt(Integer::valueOf).toArray();
   }
}
