package ch4.set_ex;

import java.util.*;

public class _2_WordsRelay {
    public boolean solution(String[] words) {
        //1)Set 이용 안 함
        String[] convertWords = Arrays.stream(words).distinct().toArray(String[]::new);
        if(convertWords.length != words.length){
            return false;
        }
        char[] charArr = words[0].toCharArray();
        char tail = charArr[charArr.length-1]; //앞 단어 끝 글자 입력
        //또는
        //tail = words[0].charAt(0);  //최초 첫 글자를 입력하기 위해서 임의로 첫 글자의 첫 문자로 셋팅, charAt으로 바로 0번째의 한 문자를 가져올 수 있습니다.

        for(int i=1 ; i<words.length ; i++){
            charArr = words[i].toCharArray();

            if(tail == charArr[0]){
                tail = charArr[charArr.length-1];
            }else
                return false;
        }
        //return true;

        //2)Set 이용
        Set<String> set = new HashSet<>();
        char headTail = words[0].charAt(0);
        for(String s : words){
            if(headTail == s.charAt(0)){
                set.add(s);
                headTail = s.charAt(s.length()-1);
            }
        }
        return set.size() == words.length;
    }
}
