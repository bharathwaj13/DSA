package week5hw;

import org.junit.Test;


public class RemoveLinkedListElements {

	/*
	 * Leetcode#203
	 * 
	 * Given the head of a linked list and an integer val, remove all the nodes of the 
	 * linked list that has Node.val == val, and return the new head.
	 */



	@Test
	public void example1() {
		ListNode head = addNode(1);
		head.next=addNode(2);
		head.next.next=addNode(6);
		head.next.next.next=addNode(3);
		head.next.next.next.next=addNode(4);
		head.next.next.next.next.next=addNode(5);
		head.next.next.next.next.next.next=addNode(6);
		ListNode output=removeElements(head,6);
		printAllNodes(output);
	}

	@Test
	public void example2() {
		ListNode head = new ListNode();
		ListNode output=removeElements(head,1);
		printAllNodes(output);
	}

	@Test
	public void example3() {
		ListNode head = addNode(7);
		head.next=addNode(7);
		head.next.next=addNode(7);
		head.next.next.next=addNode(7);
		ListNode output=removeElements(head,7);
		printAllNodes(output);
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addNode(int data) {
		return new ListNode(data);
	}

	private void printAllNodes(ListNode node) {
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}


	public ListNode removeElements(ListNode head,int k) {

		while(head!=null && head.val==k) head=head.next;

		ListNode currentNode=head;

		while(currentNode!=null && currentNode.next!=null) {
			if(currentNode.next.val==k) currentNode.next=currentNode.next.next;
			else currentNode=currentNode.next;
		}
		return head;
	}


}
