package ch4.set_ex;
import java.util.*;
public class _4_MapShortestDistance {

    class Location{
        int x;
        int y;

        Location(int x, int y){ this.x = x; this.y = y;}

        boolean equals(Location l){
            return this.x == l.x && this.y == l.y;
        }
    }

    class Position{
        int steps;
        position;
    }

    public int solution(int[][] maps) {

        target = maps.length,
        Queue<Position> queue = new LinkedList<>();
        queue.add();

        while(!queue.isEmpty()){
            Position now = queue.poll();

            if(now.position == target){
                return now.steps;
            }

            queue.offer();
        }
        return -1;
    }
}
