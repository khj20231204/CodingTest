package ch4.set_ex;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class SetEx {

    public void setEx(){
        List<MyData> list = new LinkedList<>();

        list.add(new MyData(1));
        list.add(new MyData(2));
        list.add(new MyData(3));
        list.add(new MyData(1));
        list.add(new MyData(2));
        list.add(new MyData(3));
        //System.out.println(list);

        String[] words = {"234","sdf"};
        Set<String> set2 = Arrays.stream(words).collect(Collectors.toSet());
        String[] converWords = set2.stream().toArray(String[]::new);

        String s = "dfsdf";
        char[] c = s.toCharArray();
        int aa = c.length;

        Set<MyData> set = new HashSet<>();
        set.add(new MyData(21));
        set.add(new MyData(22));
        set.add(new MyData(23));
        set.add(new MyData(21));
        set.add(new MyData(22));

        //System.out.println(set);

        HashMap<MyData,Integer> map = new HashMap<>();
        map.put(new MyData(10),1);
        //System.out.println(map);
    }

    class MyData{
        int v;

        public MyData(int v){
            this.v = v;
        }

        @Override
        public String toString(){
            return "v:"+v;
        }

        @Override
        public int hashCode(){
            System.out.println("---hashCode---");
            return Objects.hash(v);
        }

        @Override
        public boolean equals(Object obj){
            System.out.println("--- equals ---");
            if(obj instanceof MyData){
                int a = ((MyData)obj).v;
                if(v == a){
                    return true;
                }else return false;
            }
            return false;
        }
    }
}
