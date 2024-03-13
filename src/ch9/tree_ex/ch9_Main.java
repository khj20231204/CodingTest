package ch9.tree_ex;

import java.util.*;

public class ch9_Main {

    public static void main(String[] args){
        TreeEx te = new TreeEx();
        //te.treeEx();
        //te.treeUseMyData();

        HeapEx he = new HeapEx();
        //he.heapEx();;
        //he.heapUseMyData();

        _1_MoreSpicy m = new _1_MoreSpicy();
        //System.out.println(m.solution_error1(new int[]{1,1,1,3} ,3));


         /*
        Integer.valueOf()
        Integer.parseInt()
        */

        int intVar = 12;
        Integer integerVar = 34;
        String strVar = "55";

        //Integer.valueOf -> int
        int intResult = Integer.valueOf(intVar);
        intResult = Integer.valueOf(integerVar);
        intResult = Integer.valueOf(strVar);

        //Integer.valueOf -> Integer
        Integer integerResult = Integer.valueOf(intVar);
        integerResult = Integer.valueOf(integerVar);
        integerResult = Integer.valueOf(strVar);

        //Integer.parseInt -> int
        intResult = Integer.parseInt(intVar); //error
        intResult = Integer.parseInt(integerVar); //error
        intResult = Integer.parseInt(strVar);

        //Integer.parseInt -> Integer
        integerResult = Integer.parseInt(intVar); //error
        integerResult = Integer.parseInt(integerVar); //error
        integerResult = Integer.parseInt(strVar);
    }
}
