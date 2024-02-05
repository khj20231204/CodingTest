package ch8.BFS_DFS_ex;

import java.util.*;
public class DFS {
    public void dfs(){
        Nodes A = new Nodes("A");
        Nodes B = new Nodes("B");
        Nodes C = new Nodes("C");
        Nodes D = new Nodes("D");
        Nodes E = new Nodes("E");

        A.addNode(B);
        A.addNode(D);
        B.addNode(A);
        B.addNode(C);
        B.addNode(E);
        C.addNode(B);
        C.addNode(D);
        D.addNode(A);
        D.addNode(C);
        D.addNode(E);

        Stack<Nodes> stack = new Stack<>();
        stack.push(A);

        Nodes target = E;
        while(!stack.isEmpty()){
            Nodes s = stack.pop();
            s.setVisited();
            System.out.println(s.toString());

            if(s.equals(target)) break;

            s.nodeList.stream().filter(i -> !stack.contains(i) && !i.getVisited()).forEach(stack::push);
        }
    }

    class Nodes{
        String name;
        List<Nodes> nodeList;
        boolean visited = false;
        public Nodes(String name){
            this.name = name;
            nodeList = new ArrayList<>();
        }

        public void addNode(Nodes n){
            nodeList.add(n);
        }

        public void setVisited(){
            visited = true;
        }

        public boolean getVisited(){
            return visited;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public boolean equals(Object obj) {
            return name.equals(((Nodes)obj).name);
        }
    }
}
