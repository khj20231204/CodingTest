package ch8.BFS_DFS_ex;

import java.util.*;

public class ch8_Main {
    public static void main(String[] args){
        BFS b = new BFS();
        //b.bfs();

        DFS d = new DFS();
        //d.dfs();

        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        for(int i=0 ; i<2 ; i++){
            System.out.println("i:"+i);
            for(int j=0 ; j<2 ; j++){
                System.out.println("j:"+j);
                for(int s=0 ; s<6 ; s++){
                    if(s==2) break;

                    System.out.println("s:"+s);
                }
            }
        }

    }
}
