package ch8.BFS_DFS_ex;

import java.time.temporal.ChronoField;
import java.util.*;

public class ch8_Main {
    static class Node{
        char nowV;
        List<Node> list;

        public Node(char c){
            this.nowV = c;
        }
    }

    public static void main(String[] args){
        BFS b = new BFS();
        //b.bfs();

        DFS d = new DFS();
        //d.dfs();

        BFS2 b2 = new BFS2();
        b2.bfs2();
    }
}
