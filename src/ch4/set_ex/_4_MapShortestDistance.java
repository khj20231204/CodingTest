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

        Location left(){
            return new Location(x-1,y);
        }

        Location right(){
            return new Location(x+1,y);
        }

        Location up(){
            return new Location(x, y+1);
        }

        Location down(){
            return new Location(x,y-1);
        }
    }

    class Position{
        int steps;
        Location location;
        Position(Location l, int s){
            location = l; steps = s;
        }
    }

    public int solution(int[][] maps) {

        int mapSizeX = maps.length;
        int mapSizeY = maps[0].length;

        Location target = new Location(maps.length, maps[maps.length-1].length);
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(new Location(0,0),1));
        while(!queue.isEmpty()){
            Position now = queue.poll();

            //벽, 맵 밖, 중복은 체크 안한다 16:25


            if(now.location.equals(target)){
                return now.steps;
            }

            queue.offer(new Position(now.location.left(), now.steps+1));
            queue.offer(new Position(now.location.right(), now.steps+1));
            queue.offer(new Position(now.location.up(), now.steps+1));
            queue.offer(new Position(now.location.down(), now.steps+1));
        }
        return -1;
    }
}
