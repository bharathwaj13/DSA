package week5_linkedlist;

import org.junit.Test;


public class MergeLinkedList {

	@Test
	public void printMergeLinkedList() {
		Node head1=addNode(1);
		head1.next=addNode(3);
		head1.next.next=addNode(5);
		head1.next.next.next=addNode(7);
		head1.next.next.next.next=addNode(9);

		Node head2=addNode(2);
		head2.next=addNode(4);
		head2.next.next=addNode(6);
		head2.next.next.next=addNode(8);
		head2.next.next.next.next=addNode(10);


		Node merge=printMergeNodes(head1,head2);
		printNodes(merge);
	}


	public class Node{

		int data;
		Node next;

		Node(int key){
			this.data=key;
			next=null;
		}

		
		  public Node() { next=null; }
		 
	}

	public Node addNode(int data) {
		return new Node(data);
	}

	public void printNodes(Node merge) {
		while(merge!=null) {
			System.out.println(merge.data);
			merge=merge.next;
		}
	}

	public Node printMergeNodes(Node node1,Node node2) {
		Node merge=new Node();
		Node curr=merge;
		while(node1!=null && node2!=null) {
			if(node1.data>node2.data) {
				curr.next=node2;
				node2=node2.next;
			}
			else {
				curr.next=node1;
				node1=node1.next;
			}
			curr=curr.next;
		}

		if(node1==null) { curr.next=node2; 
		curr=curr.next;
		}
		else {
			curr.next=node1;
			curr=curr.next;
		}
		return merge.next;
	}




}
