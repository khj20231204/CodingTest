import java.util.*;
import java.util.stream.*;

public class Seek_the_MaximumValue_Index {
    public int[] solution1(int[] arr) {

        //최댓값 구하기
        int max = 0;
        for(int a : arr) if(a>max) {max = a;}

        //최댓값 개수
        int count = 0;
        for(int a : arr) if(a == max) count++;

        //배열 생성
        int answer[] = new int[count];
        int num = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == max) answer[num++] = i;
        }

        return answer;
    }

    public int[] solution2(int[] arr) {

        //최댓값 구하기
        int max = 0;
        for(int a : arr) if(a>max) {max = a;}

        //리스트 생성
        List<Integer> list = new LinkedList<>();
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == max) list.add(i);
        }

        //리스트를 배열로
        int[] answer = new int[list.size()];
        int num = 0;
        for(int i=0 ; i<list.size() ; i++){
            answer[num++] = list.get(i);
        }

        return answer;
    }

    public int[] solution3(int[] arr) {

        //최댓값 구하기
        int max = Arrays.stream(arr).max().getAsInt();

        //리스트 생성
        List<Integer> list = new LinkedList<>();
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == max) list.add(i);
        }

        //리스트를 배열로
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public int[] solution4(int[] arr) {
        //최댓값 구하기
        int max = Arrays.stream(arr).max().getAsInt();

        //리스트를 생성
        return IntStream.range(0, arr.length).filter(i -> arr[i] == max).toArray();
    }
}
