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

      listSelected.sort(new Comparator<Data>(){
         @Override
         public int compare(Data d1, Data d2){
            if(sort_by.equals("code")){
               return d1.code - d2.code;
            }else if(sort_by.equals("date")){
               return d1.date - d2.date;
            }else if(sort_by.equals("maximum")){
               return d1.maximum - d2.maximum;
            }else{ //remain
               return d1.remain - d2.remain;
            }
         }
      });

      int[][] answer = new int[listSelected.size()][4];
      int idx=0;
      for(Data d : listSelected){
         answer[idx][0] = d.code;
         answer[idx][1] = d.date;
         answer[idx][2] = d.maximum;
         answer[idx][3] = d.remain;
         idx++;
      }

      return answer;
   }

   //----------- 풀이2 --------------------------
   public int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {

      String[] arr = {"code", "date", "maximum", "remain"};
      List<String> columnList = Arrays.asList(arr);
      int extIdx = columnList.indexOf(ext);
      int sortIdx = columnList.indexOf(sort_by);
      int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
            .sorted((o1, o2) -> o1[sortIdx] - o2[sortIdx]).toArray(int[][]::new);

      return answer;
   }

   //----------- 풀이3 --------------------------
   public int[][] solution3(int[][] data, String ext, int val_ext, String sort_by) {
      /*return Arrays.stream(data)
            .filter(ints -> (ext.equals("code") ? ints[0] : ext.equals("date") ? ints[1] : ext.equals("maximum") ? ints[2] : ints[3]) < val_ext)
            .sorted(Comparator.comparing(ints -> sort_by.equals("code") ? ints[0] : sort_by.equals("date") ? ints[1] : sort_by.equals("maximum") ? ints[2] : ints[3]))
            .toArray(int[][]::new);*/

      return Arrays.stream(data) //data : code date maximum remain
            .filter(ss -> (ext.equals("code") ? ss[0] : ext.equals("date") ? ss[1] : ext.equals("maximum") ? ss[2] : ss[3]) < val_ext)
            .sorted(Comparator.comparing(ints -> sort_by.equals("code") ? ints[0] : sort_by.equals("date") ? ints[1] : sort_by.equals("maximum") ? ints[2] : ints[3]))
            .toArray(int[][]::new);
   }

   //----------- 풀이4 --------------------------
   public List<int[]> solution4(int[][] data, String ext, int val_ext, String sort_by) {
      List<int[]> list = new ArrayList<>();
      String[] s = {"code", "date", "maximum", "remain"};
      int extIdx = 0, sortIdx = 0;

      for (int i = 0; i < 4; i++) {
         if (ext.equals(s[i])) extIdx = i;
         if (sort_by.equals(s[i])) sortIdx = i;
      }
      final int si = sortIdx;

      for (int i = 0; i < data.length; i++) {
         if (data[i][extIdx] < val_ext) list.add(data[i]);
      }

      // *lambda, Comparator 사용시 final 이나 effectively final여야한다!
      Collections.sort(list, (o1, o2) -> o1[si] - o2[si]);


      return list;
   }
}
