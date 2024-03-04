package ch8.BFS_DFS_ex;

import java.util.*;

public class _4_MapShortestDistance2 {

   private class Location {
      int x;
      int y;

      public Location(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public boolean equals(Object o) {
         Location l = (Location) o;
         return (this.x == l.x && this.y == l.y);
      }
   }
   private class Position{
      int steps;
      Location location;

   }

   public int solution(int[][] maps){

      Location target = new Location(maps.length, maps[maps.length-1].length);

      Queue<Position> queue = new LinkedList<>();
      queue.add();

      while(!queue.isEmpty()){
         Position now = queue.poll();

         if(now.location.equals(target)){
            return now.steps;
         }
         now.location.x - 1;
         queue.offer(new Position());
      }

      return -1;
   }
}
