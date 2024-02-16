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

        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(2);
        list.add(4);

        for(int i : list){
            System.out.println(i);
        }
    }
}
