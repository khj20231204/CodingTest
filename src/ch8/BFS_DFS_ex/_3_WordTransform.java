package ch8.BFS_DFS_ex;

import java.util.*;

public class _3_WordTransform {

    class Word{
        String word;
        int depth;
        Word(String w, int d){ word = w; depth = d;}
    }

    public int solution(String begin, String target, String[] words) {

        if(!Arrays.asList(words).contains(target)) return 0;

        int answer = words.length;
        Set<String> used = new HashSet<>();

        Stack<Word> stack = new Stack<>();
        stack.add(new Word(begin,0));
        while(!stack.isEmpty()){
            Word now = stack.pop();

            if(now.word.equals(target)) return now.depth;

            for(String w : words){
                if(changable(now.word, w)) continue;
                if(used.contains(w)) continue;

                used.add(w);
                stack.push(new Word(w, now.depth+1));
            }
        }

        return answer;
    }

    boolean changable(String w1, String w2){
        int len = Math.min(w1.length(), w2.length());
        int count = 0;
        for(int i=0 ; i<len && count < 2 ; i++){
            if(w1.charAt(i) != w2.charAt(i)) count++;
        }

        return count == 1;
    }
}
