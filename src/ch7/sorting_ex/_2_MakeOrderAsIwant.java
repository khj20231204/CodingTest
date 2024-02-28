package ch7.sorting_ex;

import java.util.Arrays;
import java.util.Comparator;

public class _2_MakeOrderAsIwant {
    //문자를 앞에 붙이기
    public static String[] solution1(String[] strings, int n){
        String[] answer = new String[strings.length];

        for(int i=0 ; i<strings.length ; i++) answer[i] = strings[i].charAt(n)+strings[i];

        Arrays.sort(answer);

        for(int i=0 ; i<strings.length ; i++) answer[i] = answer[i].substring(1,answer[i].length());

        return answer;
    }

    //for문 이용 아스키코드로 정렬
    public static String[] solution2(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Arrays.sort(strings);

        //65~90 97~122
        int count = 0;
        for(int i=97 ; i<=122 ; i++){
            for(int j=0 ; j<strings.length ; j++){
                if(strings[j].charAt(n) == (char)i ){
                    answer[count++] = strings[j];
                }
            }
        }
        return answer;
    }

    //sort재정의
    public static String[] solution3(String[] strings, int n) {

        Arrays.sort(strings);

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) return 1;
                else if(o1.charAt(n) < o2.charAt(n)) return -1;
                return 0;
            }
        });

        return strings;
    }

    //람다
    public static String[] solution4(String[] strings, int n) {

        Arrays.sort(strings);

        Arrays.sort(strings, (o1,o2) -> {
            if (o1.charAt(n) > o2.charAt(n)) return 1;
            else if(o1.charAt(n) < o2.charAt(n)) return -1;
            return 0;
        });
        return strings;
    }
}
