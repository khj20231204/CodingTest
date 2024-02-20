package ch2.list_ex;

import java.util.*;

public class ch2_Main {
    public static void main(String[] args) {

        _1_Seek_the_MaximumValue_Index smi = new _1_Seek_the_MaximumValue_Index();
        int[] matter = {3,5,4,6,3,3,6,5};
        //int[] smi_answer = smi.solution1(matter);

        _2_order_check oc = new _2_order_check();
        //boolean oc_answer = oc.solution1(matter);

        //List_exercise();

        String s = "5256";
        Integer in = Integer.valueOf(s);
        int in2 = Integer.valueOf(s);
        Double d = Double.valueOf(s);
        double d2 = Double.valueOf(s);
        Long l = Long.valueOf(s);
        long l2 = Long.valueOf(s);

        System.out.println(in + " in2:" + in2 + " d:" + d + " d2:"+d2+ " l:"+l+" l2"+l2);
    }

    static void List_exercise(){
        List<Integer> list = new LinkedList<>();

        //add get contains remove
        for(int i=2 ; i<7 ; i++){ list.add(i); }
        list.remove(3);
        System.out.println(list);

        System.out.println(list);
        list.add(10);
        list.add(1,24);
        System.out.println(list);

        System.out.println(list.get(3));
        System.out.println(list.contains(3));

        List<String> str = new LinkedList<>();
        str.add("a");
        str.add("bb");
        str.add("cc");
        str.add("dd");
        System.out.println(str);
        str.remove(1);
        System.out.println(str);



    }
}