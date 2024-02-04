package ch8.BFS_DFS_ex;

import java.util.*;

class Node{
    String name;
    List<Node> links;
    boolean chekc = false;

    public Node(String name){
        this.name = name;
        links = new LinkedList<>();

        Set<String> s = new HashSet<>();
        s.add("a");
        s.add("b");
        s.add("c");

        Set<String> s2 = new HashSet<>();
        s.forEach(s2::add);

        //System.out.println(s2.toArray());
    }

    @Override
    public String toString(){
        return name;
    }

    void linkNode(Node node){
        links.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(name, ((Node)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    void checkPoll(){
        this.chekc = true;
    }

    boolean isCheckPoll(){
        return chekc;
    }
}

public class GraphArgol {

    public GraphArgol(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.linkNode(b);
        a.linkNode(d);
        b.linkNode(a);
        b.linkNode(c);
        b.linkNode(e);
        c.linkNode(b);
        c.linkNode(d);
        d.linkNode(a);
        d.linkNode(c);
        d.linkNode(e);
        e.linkNode(b);
        e.linkNode(d);

        Node target = e;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(a);

        while(!queue.isEmpty()){

            Node t = queue.poll();
            t.checkPoll();
            System.out.println("node:"+ t.toString());
            if(t.equals(target)) break;

            t.links.stream().filter(i->!queue.contains(i) && !i.isCheckPoll()).forEach(queue::offer);
        }


    }
    class BFS{

        Queue<Node> queue;

        public BFS(){
            queue = new LinkedList<>();
        }
        public void bfs(){


            //queue.offer(a);
        }
    }

    class DFS{


    }
}


