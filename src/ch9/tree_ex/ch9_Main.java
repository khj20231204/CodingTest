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
        m.solution_error1(new int[]{1,2,1,3} ,20);

        Stack<Integer> s = new Stack<>();
        s.push(12);
        s.push(6);
        s.push(14);
        s.push(8);

        Collections.sort(s, Collections.reverseOrder());

        //System.out.println("s:"+s);
        //System.out.println(s.pop());
    }
}
