package progrms.codingtest_ex;

public class desktopArrangement {
   public int[] solution(String[] wallpaper) {
      int top = wallpaper.length; //i최소
      int left = wallpaper[0].length(); //count최소
      int bottom = 0; //i최대
      int right = 0; //count최대

      for(int i=0 ; i<wallpaper.length ; i++){

         String str = wallpaper[i];
         char[] arr = str.toCharArray();
         int count = 0;
         for(char c : arr){
            if(c == '#'){
               if(top > i) top = i;
               if(left > count) left = count;
               if(bottom < i) bottom = i;
               if(right < count) right = count;
            }
            count++;
         }
      }

      bottom++;
      right++;
      int[] answer = {top, left, bottom, right};

      return answer;
   }
}
