package ch8.BFS_DFS_ex;

import java.util.*;

public class StringCompare {
    public int solution(String s1, String s2){
        /*
        s1과 s2의 글자 길이가 같다
        "aaobbg"와 "aoffbc" -> 같은 문자 소거 후 abg 외 ffc가 남음
        "dog" 와 tto" -> 같은 문자 소거 후 dg와 tt가 남음
         */

        if(s1.length() != s2.length()) return 0;

        return 0;
    }

    String checkChars(String s1, String s2){
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();

        int count=0;
        Queue<Character> s1Q = new LinkedList<>();
        Queue<Character> s2Q = new LinkedList<>();
        for(int i=0 ; i<s1CharArr.length ; i++){

            for(int j=0 ; j<s2CharArr.length ; j++){

            }

        }

        return "";
    }
}
