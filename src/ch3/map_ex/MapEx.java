package ch3.map_ex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapEx {

    public void mapEx(){
        //put, get, containsKey, containsValue, getOrDefault, replace, keyset, values, size, isEmpty, remove
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A",19);
        map.put("B",300);
        map.put("C",56);

        System.out.println(map);
        System.out.println("get(A):" + map.get("A"));
        System.out.println("get(B):" + map.get("B"));
        System.out.println("containsKey(A):" + map.containsKey("A"));;
        System.out.println("containsValue(300)" + map.containsValue(300));
        System.out.println("getOrDefault(C,-1):" + map.getOrDefault("C",-1));
        map.replace("C",200);
        System.out.println("replacle C:"+map.get("C"));

        Set<String> mapKey = map.keySet();
        for(String s : mapKey){
            System.out.println("keySet:"+ mapKey);
        }

        Collection<Integer> mapValues = map.values();
        for(Integer i : mapValues){
            System.out.println("keyValues:"+i);
        }

        System.out.println("size():" + map.size());
        System.out.println("isEmpty():" + map.isEmpty());

        map.remove("B");
        System.out.println("remove:"+map.get("B"));

        //equals를 사용하는 메소드 : get, containsKey, replace, remove
        HashMap<MyData, Integer> objMap = new HashMap<>();
        System.out.println("--------- put 시작 ---");
        objMap.put(new MyData(2), 11);
        objMap.put(new MyData(3), 12);
        objMap.put(new MyData(6), 13);
        System.out.println("--------- put 끝---");

        System.out.println(objMap);
        System.out.println("--------- get 시작 ---");
        System.out.println("get(new MyData(2)):" + objMap.get(new MyData(2)));

        System.out.println("--------- containsKey 시작 ---");
        System.out.println("containsKey(new MyData(2)):" + objMap.containsKey(new MyData(2)));;

        System.out.println("--------- getOrDefault 시작 ---");
        System.out.println("getOrDefault(C,-1):" + objMap.getOrDefault("C",-1));

        System.out.println("--------- replacle 시작 ---");
        objMap.replace(new MyData(3),200);
        System.out.println("replacle C:"+objMap.get(new MyData(3)));

        System.out.println("---------keySet 시작 ---");
        Set<MyData> objMapKey = objMap.keySet();
        for(MyData s : objMapKey){
            //System.out.println("keySet:"+ s.key);
        }

        System.out.println("--------- values 시작 ---");
        Collection<Integer>  objValues = objMap.values();
        for(Integer i : objValues){
            System.out.println("keyValues:"+i);
        }

        System.out.println("--------- size 시작 ---");
        System.out.println("size():" + objMap.size());

        System.out.println("--------- isEmpty 시작 ---");
        System.out.println("isEmpty():" + objMap.isEmpty());

        System.out.println("--------- remove 시작 ---");
        objMap.remove(new MyData(3));
        System.out.println("remove:"+objMap.get(new MyData(3)));
    }
}
