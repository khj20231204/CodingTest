package mycodingtest.ch08.node_ex;

import java.util.*;

class Node{
	String name;
	List<Node> next;
	
	public Node(String n){
		name = n;
		next = new ArrayList<>();
	}
	
	public void link(Node n) {
		this.next.add(n);
	}
	
	public String toString() {
		return name;
	}
}

public class SortingNode {
	
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		A.link(B);
		A.link(D);
		B.link(A);
		B.link(C);
		B.link(E);
		C.link(B);
		C.link(D);
		D.link(A);
		D.link(C);
		D.link(E);
		E.link(B);
		E.link(D);
		
		List<Integer> intVar = new ArrayList<>();
		int[] intArr = new int[5];
		for(int i=0 ; i<5 ; i++) {
			int r = (int)(Math.random()*10);
			intVar.add(r);
			intArr[i] = r;
		}
		
		intVar.stream().forEach(System.out::println);
		System.out.println("");
		Arrays.stream(intArr).forEach(System.out::println);
		
		Queue<Integer> queue = new LinkedList<>();
		Arrays.stream(intArr).forEach(queue::offer);
		
		System.out.println(queue);
		
	}

}



