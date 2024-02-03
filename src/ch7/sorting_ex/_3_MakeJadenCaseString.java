package ch7.sorting_ex;

public class _3_MakeJadenCaseString {

    public static String solution(String s) {
        String answer = "";

        answer = s.toLowerCase();
        System.out.println(answer);

        char[] charArr = s.toCharArray();
        int len = charArr.length;

        charArr[3] = 'a'+2;

        boolean check = false;
        for(int i=0 ; i<len ; i++){
            if(charArr[i] == ' ') check = true;
             /*
            if(check){
                if(charArr[i+1] != ' ')
                    charArr[i+1] = charArr[i+1] - 'a';
            }
            */

        }

        answer = String.valueOf(charArr);
        return answer;
    }
}
