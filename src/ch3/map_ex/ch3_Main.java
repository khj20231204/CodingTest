package ch3.map_ex;

import java.util.*;

public class ch3_Main {

    public static void main(String[] args){

        MapEx me = new MapEx();
        me.mapEx();

        String[][] cloth = {{"a","b","c"},{"d","e","f"}};

        for(String[] s : cloth){
            System.out.println(s[0] + s[1] + s[2]);
        }
    }
}

