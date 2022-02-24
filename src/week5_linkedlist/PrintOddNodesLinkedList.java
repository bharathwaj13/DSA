package week5_linkedlist;

import org.junit.Test;

public class PrintOddNodesLinkedList {

	@Test
	public void printOddNodeLinkedList() {
		Node head=addNode(1);
		head.next=addNode(2);
		head.next.next=addNode(3);
		head.next.next.next=addNode(4);
		head.next.next.next.next=addNode(5);
		printOddNodes(head);
	}


	public class Node{

		int data;
		Node next;

		Node(int key){
			this.data=key;
			next=null;
		}
	}

	public Node addNode(int data) {
		return new Node(data);
	}

	public void printOddNodes(Node node) {
		while(node.next!=null) {
			System.out.println(node.next.data);
			node=node.next.next;
		}
	}

}
