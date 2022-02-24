package week5_linkedlist;

import org.junit.Test;


public class RemoveDuplicatesSortedLinkedList {


	/*
	 * Leetcode: 83 Given the head of a sorted linked list, delete all duplicates
	 * such that each element appears only once. Return the linked list sorted as
	 * well.
	 */

	/*
	 * @Test public void example1() { ListNode head1=addNode(1);
	 * head1.next=addNode(1); head1.next.next=addNode(2); ListNode
	 * output=removeDuplicates(head1); printNodes(output); }
	 */

	@Test
	public void example2() {
		ListNode head1=addNode(1);
		head1.next=addNode(1);
		head1.next.next=addNode(2);
		head1.next.next.next=addNode(3);
		head1.next.next.next.next=addNode(3);
		head1.next.next.next.next.next=addNode(3);
		ListNode output=removeDuplicates(head1);
		printNodes(output);
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

	public void printNodes(ListNode merge) {
		while(merge!=null) {
			System.out.println(merge.val);
			merge=merge.next;
		}
	}

	public ListNode removeDuplicates(ListNode node) {
		if(node == null || node.next == null ) return node;
		ListNode prev = node;
		ListNode curr = node.next;
		while(curr != null) {
			if(prev.val == curr.val) prev.next = curr.next;
			else prev = curr;
			curr = curr.next;
		}
		return node; 
	}



}
