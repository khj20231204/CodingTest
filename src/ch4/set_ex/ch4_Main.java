package ch4.set_ex;

import java.util.*;

public class ch4_Main {
    public static void main(String[] args){

        SetEx se = new SetEx();
        //se.setEx();

        _3_HateSameNumber_ListUseError hsnError = new _3_HateSameNumber_ListUseError();
        //hsnError.solution(new int[]{1,1,3,3,0,1,1});

        for(int i=0 ; i<2 ; i++){

            System.out.println("-------- i --------");
            int a = 0;
            for(int j=0 ; j<5 ; j++){

                if(j == 2) {
                    a = j;
                    break;
                }


            }

            System.out.println(a);
        }
    }
}
