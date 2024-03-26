package ch7.sorting_ex;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class _1_RemoveLeastNumber {
    public static int[] solution1(int[] arr) {
        int len = arr.length;

        if (len <= 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[arr.length - 1];
        int cnt = 0;
        for (int i : arr) {
            if (i == min) continue;

            answer[cnt++] = i;
        }
        return answer;
    }

    public static int[] solution2(int[] arr) {
        if (arr.length <= 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(a -> a != min).toArray();
    }
}
