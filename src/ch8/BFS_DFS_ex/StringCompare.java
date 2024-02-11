package ch8.BFS_DFS_ex;

import java.util.*;

public class StringCompare {
    public int solution(String s1, String s2){

        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();

        Queue<Character> q = new LinkedList<>();
        int count=0;
        for(int i=0 ; i<s1CharArr.length ; i++){

            q.offer(s1CharArr[i]);
            boolean check = false;
            while(!q.isEmpty()){

                char c = (char)q.poll();
                for(int j=0 ; j<s2CharArr.length ; j++){
                    if(c != (char)s2CharArr[j]);
                }
            }

        }

        return 0;
    }
}
