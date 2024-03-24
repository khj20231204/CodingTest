package ch6.search_ex;

import java.util.*;

public class _1_PhoneNumberList {
    public boolean solution(String[] book) {
        boolean answer = true;

        Arrays.sort(book);
        for(int i=0 ; i<book.length-1 ; i++){
            if(book[i+1].startsWith(book[i])) return false;
        }
        return true;
    }
    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        String before = "1"+phone_book[0];
        for(String s : phone_book){
            if(s.startsWith(before)) return false;
            before = s;
        }

        return true;
    }

}
