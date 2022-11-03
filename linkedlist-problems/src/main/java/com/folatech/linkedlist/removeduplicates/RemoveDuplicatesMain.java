package com.folatech.linkedlist.removeduplicates;

/**
 * Remove duplicates from a sorted linked list
 *
 */
public class RemoveDuplicatesMain {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList(1);
		LinkedList linkedList1 = linkedList.next = new LinkedList(2);
		LinkedList linkedList2 = linkedList1.next = new LinkedList(2);
		LinkedList linkedList3 = linkedList2.next = new LinkedList(3);
		LinkedList linkedList4 = linkedList3.next = new LinkedList(4);
		LinkedList linkedList5 = linkedList4.next = new LinkedList(4);
		LinkedList linkedList6 = linkedList5.next = new LinkedList(6);

		printLinkedList(linkedList);
		linkedList = removeDuplicatesFromSortedLinkedList(linkedList);
		printLinkedList(linkedList);

	}

	static LinkedList removeDuplicatesFromSortedLinkedList(LinkedList linkedList) {

		if (linkedList == null) {
			return linkedList;
		}
		LinkedList node = linkedList;

		/**
		 * searching and removing duplicates
		 */
		while (node.next != null) {
			// checking for duplicates
			if (node.value == node.next.value) {

				// removing duplicate
				node.next = node.next.next;
			} else {

				// go to the next if next is not a duplicate
				node = node.next;
			}
		}
		return linkedList;
	}

	static void printLinkedList(LinkedList linkedList) {
		System.out.println("Printing LinkedList");
		while (linkedList != null) {
			System.out.println("linkedList value: " + linkedList.value);

			if (linkedList.next == null) {
				break;
			}

			linkedList = linkedList.next;
		}
		System.out.println("\n");
	}

	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
}
