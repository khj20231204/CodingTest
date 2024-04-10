package progrms.codingtest_ex;
import java.util.*;
public class dataAnalysis {

   class Data{
      int code;
      int date;
      int maximum;
      int remain;

      public Data(int code, int date, int maximum, int remain){
         this.code = code;
         this.date = date;
         this.maximum = maximum;
         this.remain = remain;
      }

      public String toString(){
         return "code:"+code+" ,date:"+date+" ,maximum:"+maximum+" ,remain:"+remain;
      }
   }

   public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {


      List<Data> list = new ArrayList<>();
      for(int[] i : data){
         int code = i[0];
         int date = i[1];
         int maximum = i[2];
         int remain = i[3];

         list.add(new Data(code, date, maximum, remain));
      }

      List<Data> listSelected = new ArrayList<>();
      if(ext.equals("code")){
         for(Data d : list){
            if(d.code < val_ext) listSelected.add(d);
         }
      }else if(ext.equals("date")){
         for(Data d : list){
            if(d.date < val_ext) listSelected.add(d);
         }
      }else if(ext.equals("maximum")){
         for(Data d : list){
            if(d.maximum < val_ext) listSelected.add(d);
         }
      }else{ //remain
         for(Data d : list){
            if(d.remain < val_ext) listSelected.add(d);
         }
      }

      for(Data d : listSelected){
         System.out.println(d);
      }

      /*
      listSelected.sort(new Comparator<Data>(){
         @Override
         public int compare(Data d1, Data d2){
            if(sort_by.equals("code")){
               return d2.code - d1.code;
            }else if(sort_by.equals("date")){
               return d2.date - d1.date;
            }else if(sort_by.equals("maximum")){
               return d2.maximum - d1.maximum;
            }else{ //remain
               System.out.println("d1.remain:"+d1.remain+" ,d2.remain:"+d2.remain);
               return -1;
            }
         }
      });
      */

      listSelected.sort(new Comparator<Data>() {
         @Override
         public int compare(Data o1, Data o2) {
            return -1;
         }
      });

      System.out.println(listSelected.size());
      int[][] answer = new int[listSelected.size()][4];
      for(Data d : listSelected){
         d.toString();
         System.out.println("d.remain:"+d.remain);
      }

      return answer;
   }
}
