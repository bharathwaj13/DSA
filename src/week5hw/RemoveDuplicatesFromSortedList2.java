package week5hw;

import org.junit.Test;


public class RemoveDuplicatesFromSortedList2 {

	/*
	 * Leetcode#82
	 * 
	 * Given the head of a sorted linked list, delete all nodes that have duplicate
	 * numbers, leaving only distinct numbers from the original list. Return the
	 * linked list sorted as well.
	 */

	@Test
	public void example1() {
		ListNode head = addNode(1);
		head.next=addNode(2);
		head.next.next=addNode(3);
		head.next.next.next=addNode(3);
		head.next.next.next.next=addNode(4);
		head.next.next.next.next.next=addNode(4);
		head.next.next.next.next.next.next=addNode(5);
		ListNode result=removeDuplicates(head);
		printAllNodes(result);
	}

	@Test
	public void example2() {
		ListNode head = addNode(1);
		head.next=addNode(1);
		head.next.next=addNode(1);
		head.next.next.next=addNode(2);
		head.next.next.next.next=addNode(3);
		ListNode result=removeDuplicates(head);
		printAllNodes(result);
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

	public ListNode removeDuplicates(ListNode head) {

		ListNode dummy = new ListNode(0,head);
		ListNode prev=dummy;

		while(head!=null) {
			if(head.next!=null && head.val==head.next.val) {
				//skip the nodes whose values are equal to head
				while(head.next!=null && head.val==head.next.val) {
					head=head.next;
				}
				prev.next=head.next;
			}
			else {
				prev=prev.next;
			}
			head=head.next;
		}
		return dummy.next;

	}

}
