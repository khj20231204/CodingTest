package ch6.search_ex;

import java.util.*;

//search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있다. : 완전탐색
//equals 재정의

//이진탐색 : Collections.binarySearch
//Comparable 재정의
//순서대로 정렬되어 있어야 함

public class ch6_Main {
    public static void main(String[] args){
        String s = "abc";
        String s1 = "abd";

        System.out.println(s.contains(s1));
    }
}
