import java.util.*;
import java.util.stream.Collectors;

public class Josephus_permuation {
    void solution(){

        //list -> array
        List<Integer> list = new ArrayList<>();
        int[] b = list.stream().mapToInt(Integer::intValue).toArray();

        //map -> array
        Map<String, Integer> map = new HashMap<>();
        int[] a = map.values().stream().mapToInt(Integer::intValue).toArray();
        String[] s= map.keySet().toArray(new String[0]);
        //array -> list
        List<Integer> list2 = Arrays.stream(a).boxed().collect(Collectors.toList());

        //arry -> map

        System.out.printf("Josephus");
    }
}
