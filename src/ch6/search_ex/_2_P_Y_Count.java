package ch6.search_ex;

public class _2_P_Y_Count {
    boolean solution1(String s) {
        String sUpper = s.toUpperCase();

        int count = 0;
        for(char c : sUpper.toCharArray()){
            if(c == 'P'){
                count++;
            }else if(c == 'Y'){
                count--;
            }else continue;
        }

        return count == 0;
    }

    boolean solution2(String s) {
        int p = s.replaceAll("[^pP]","").length();
        int y = s.replaceAll("[^yY]","").length();

        return p == y;
    }
}
