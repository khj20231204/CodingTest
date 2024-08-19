package mycodingtest.ch08.node_ex;

import java.util.*;



public class SortingNode {

	class Node{	//내부 클래스
		String name;
		
		public Node(String n) {
			name = n;
		}
		
		
		public String toString() {
			return this.name;
		}
	}
	
	public static void main(String[] args) {

		List<Node> nodes = new ArrayList<>();
		
		SortingNode sn = new SortingNode();
		SortingNode.Node snn = sn.new Node("A");
		
		nodes.add(sn.new Node("A"));
		nodes.add(sn.new Node("B"));
		nodes.add(sn.new Node("C"));
		
		System.out.println(nodes);
	}
	
	public void a() {
		List<Node> nodes = new ArrayList<>();

		nodes.add(new Node("A"));
	}
	
	public static void b() {

		List<Node> nodes = new ArrayList<>();
		
		SortingNode sn = new SortingNode();
		SortingNode.Node snn = sn.new Node("A");
		
		nodes.add(sn.new Node("A"));
		nodes.add(sn.new Node("B"));
		nodes.add(sn.new Node("C"));
		
		System.out.println(nodes);
	}
	
}

