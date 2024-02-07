package ch8.BFS_DFS_ex;

import java.util.*;

public class _3_WordTransform {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;

        Stack<String> stack = new Stack<>();
        stack.add(begin);
        while(!stack.isEmpty()){
            String now = stack.pop();

            for(String w : words){

            }
        }
        return 0;
    }

    class Word{

    }
}
