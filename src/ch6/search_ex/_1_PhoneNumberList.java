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
}
