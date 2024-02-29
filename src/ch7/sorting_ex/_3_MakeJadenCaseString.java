package ch7.sorting_ex;

public class _3_MakeJadenCaseString {
    public String solution(String s) {
        String answer = "";

        s = s.toLowerCase();

        char[] charArr = new char[s.length()];

        char before = ' ';
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(before == ' ') c = Character.toUpperCase(c);

            charArr[cnt++] = c;
            before = c;
        }

        answer = String.valueOf(charArr);


        return answer;
    }
}
