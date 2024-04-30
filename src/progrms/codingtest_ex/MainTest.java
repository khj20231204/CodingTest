package progrms.codingtest_ex;

public class MainTest {
   public static void main(String args[]){
      dataAnalysis da = new dataAnalysis();

      int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
      String ext = "date";
      int val_ext = 20300501;
      String sort_by = "remain";

      //da.solution2(data, ext, val_ext, sort_by);

      PrivacyExpirationPeriod pep = new PrivacyExpirationPeriod();
      String[] t1 = {"A 6", "B 12", "C 3"};
      String[] t2 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
      pep.solution("2022.05.19",t1, t2);
   }
}
