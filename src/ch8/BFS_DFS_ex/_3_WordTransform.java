package ch8.BFS_DFS_ex;

import java.util.*;

public class _3_WordTransform {
    class Word{
        String word;
        int depth;

        Word(String w, int d){word=w; depth=d;}
    }

    public int solution(String begin, String target, String[] words) {

        if(!Arrays.asList(words).contains(target)) return 0;
        //List<String> l = Arrays.stream(words).filter(w -> w.equals(target)).collect(Collectors.toList());

        //while문에서 스택이나 큐에 있는 값을 가져오고
        //for문으로 검색을 해서 스택이나 큐에 넣고
        Word w = new Word(begin, 0);
        Queue<Word> q = new LinkedList<>();
        q.offer(w);

        List<String> list = new ArrayList<>();

        while(!q.isEmpty()){
            w = q.poll();

            if(w.word.equals(target)) return w.depth; //문자열 비교는 equals

            for(String s : words){
                System.out.println(changeable(w.word, s));
                if(!changeable(w.word, s)) continue;
                if(list.contains(s)) continue; //list는 true일 때 continue

                q.offer(new Word(s, w.depth+1));
                list.add(s);
            }
        }
        return 0;
    }

    boolean changeable(String s1, String s2){
        if (s1.length() != s2.length()) return false;

        int cnt = 0;
        for(int i=0 ; i<s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}
