package ch2.list_ex;

import java.util.*;
public class ListEx {
   public void listEx(){
      List<Integer> list = new LinkedList<>();

      //add get contains remove
      for(int i=2 ; i<7 ; i++){ list.add(i); }
      list.remove(3);
      System.out.println(list);

      System.out.println(list);
      list.add(10);
      list.add(1,24);
      System.out.println(list);

      System.out.println(list.get(3));
      System.out.println(list.contains(3));

      List<String> str = new LinkedList<>();
      str.add("a");
      str.add("bb");
      str.add("cc");
      str.add("dd");
      System.out.println(str);
      str.remove(1);
      System.out.println(str);
   }

   static class MyData{
      String name;
      public MyData(String name){
         this.name = name;
      }
      public static MyData create(String s){
         return new MyData(s);
      }

      public String toString(){
         return name+" ";
      }

      @Override
      public boolean equals(Object o){
         return name.equals(((MyData)o).name);
      }
   }

   void useMyData(){
      LinkedList<MyData> str = new LinkedList<>();
      str.add(MyData.create("Brown"));
      str.add(new MyData("tom"));

      System.out.println(str.toString());
      System.out.println(str.contains(new MyData("tom")));
   }
}
