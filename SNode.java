/**
* A Node class for Singly Linked List
* Storing positive generic elements
* *Note: We made the node elements generic in order to have parallel singly linked lists
* 	of the  characters as well as their indices in the String
*/

public class SNode<E>{
	private E element;	//The char element stored at the node
	private SNode next;		//Reference/Pointer to the next node

	//Constructor
	public SNode(E e, SNode n) {
		element = e;
		next = n;
	}

	public E getElement() {
		return element;
	}

	public SNode getNext() {
		return next;
	}

	public void setElement(E newElement) {
		element = newElement;
	}

	public void setNext(SNode newNext) {
		next = newNext;
	}

	//Returns the string representation of the SNode
	public String toString() {
		return "(" + element + ")";	
	}

}