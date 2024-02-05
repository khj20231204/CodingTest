package ch8.BFS_DFS_ex;

import java.util.*;

public class ch8_Main {
    public static void main(String[] args){
        BFS b = new BFS();
        //b.bfs();

        DFS d = new DFS();
        //d.dfs();

        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        _1_Network.solution(3, computers);

    }
}
