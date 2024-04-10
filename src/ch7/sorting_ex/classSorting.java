package ch7.sorting_ex;
import java.util.*;

public class classSorting {
   class MyData{
      int a;
      int b;
      String str;

      public MyData(int a, int b, String s){
         this.a = a;
         this.b = b;
         str = s;
      }
   }

   public void solution(){

      //List 정렬
      List<Integer> list = new ArrayList<>();
      for(int i=0 ; i<10; i++){
         list.add((int)Math.random());
      }

      list.sort(new Comparator<Integer>(){
         public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
         }
      });

      //클래스 정렬
      List<MyData> list2 = new ArrayList<>();
      list2.add(new MyData(32,5,"b"));
      list2.add(new MyData(6,19,"d"));
      list2.add(new MyData(13,7,"p"));

      list2.sort(new Comparator<MyData>(){
         @Override
         public int compare(MyData o1, MyData o2){
            return o2.a - o1.a;
         }
      });

      for(MyData m : list2){
         System.out.println("a:"+m.a+" ,b:"+m.b+" ,str:"+m.str);
      }

      list2.sort(new Comparator<MyData>() {
         @Override
         public int compare(MyData o1, MyData o2) {
            return o2.str.compareTo(o1.str);
         }
      });

      for(MyData m : list2){
         //System.out.println("a:"+m.a+" ,b:"+m.b+" ,str:"+m.str);
      }
   }
}
