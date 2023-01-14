/**
* A Singly Linked Class
* Storing a list of SNode nodes with char elements
* Note: We made this list generic in order to have parallel singly linked lists
* 	of the  characters as well as their indices in the String
*/

public class SinglyLinkedList<E>{
	private SNode head;		//The head node of the list
	private SNode tail;		//The tail node of the list
	int size;				//The number of nodes in the list

	//Constructor method
	public SinglyLinkedList() {
		 head = null;		//head and tail are null in an empty list
		 tail = null;
		 size = 0;
	}

	//ACCESS METHODS
	//Returns the number of nodes in the list
	public int size() {
		return size;
	}

	//Returns true of the list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns the first element in the list, null if empty
	public E first() {
		if (isEmpty()) return null;
		return (E)head.getElement();
	}

	//Returns the last element in the list, null if empty
	public E last() {
		if (isEmpty()) return null;
		return (E)tail.getElement();
	}

	//Adds a new element to the front of the list
	public void addFirst(E e) {
		SNode newNode = new SNode(e, head);
		head = newNode;
		if (isEmpty()) { tail = head; }	//Special case
		size++;
	}

	//Add a new element to the end of the list
	public void addLast(E e) {
		SNode newNode = new SNode(e, null);
		if (isEmpty()) { head = newNode; }	//Special case
		else {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	//Removes and returns the first element of the list
	//Returns null if list is empty
	public E removeFirst() {
		if (isEmpty()) { return null; }
		SNode temp = head;
		head = head.getNext();
		size--;
		if (isEmpty()) { tail = null; }
		temp.setNext(null);		//Optional
		return (E)temp.getElement();
	}

	//Prints the elements of the list
	public void display() {
		SNode current = head;
		while (current != null) {      // for each SNode,
			System.out.print(current + " ");  // display it		}
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public boolean equals(SinglyLinkedList other) {
		if (other == null) return false;
		if (size != other.size()) return false;
		SNode current = head;
		SNode otherCurrent = other.head;
		while (current != null) {
			if (current.getElement() != otherCurrent.getElement())
				return false;
			//If elements were objects then we would use the equals method instead of !=
			//if (!current.getElement().equals(otherCurrent.getElement()))
			current = current.getNext();
			otherCurrent = otherCurrent.getNext();
		}
		return true;
	}
	
	//Removes and returns the last element in the list
	public E removeLast() {
		if (isEmpty()) return null;
		if (size == 1) return removeFirst();
		
		SNode current = head;
		SNode ahead = head.getNext();
		while (ahead.getNext() != null) {
			current = current.getNext();
			ahead = ahead.getNext();
		}
		current.setNext(null);
		tail = current;
		size--;
		return (E)ahead.getElement();
	}
	

}