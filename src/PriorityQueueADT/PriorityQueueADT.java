package PriorityQueueADT;

import LinkedListADT.Node;

public class PriorityQueueADT<E> {
	Node<E> firstNode;
	
	public boolean push(E data, Integer priority) {
		Node<E> node = new Node<E>();
		node.setData(data);
		node.setPriority(priority);
		if(firstNode == null) {
			firstNode = node;
			return true;
		}
		else {
			if(firstNode.getPriority() > node.getPriority()) {
				node.setNext(firstNode);
				firstNode = node;
				return true;
			}
			else {
			// search until finding the node with same priority using loop
			// if node's priority higher than the node which comes after the temporary node and if it is not the last node 
			// exit from the loop
			Node<?> tempNode = this.firstNode;
			while(tempNode.getNext() != null && tempNode.getNext().getPriority() <= node.getPriority()) {
				tempNode = tempNode.getNext();
					
				}
			// add the node 
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			return true;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		if(firstNode == null) {
			return null;
		}
		Node<E> deletedNode = new Node<E>();
		deletedNode = firstNode;
		firstNode = (Node<E>) firstNode.getNext();
	
		return deletedNode.getData();
		}
	
	public E peek() {
		if(firstNode == null) {
			return null;
		}
		return firstNode.getData();
	}
	
	public void show() {
		if(firstNode == null) {
			System.out.println("List is empty");
		}
		else {
		Node node = firstNode;
		while(node.getNext() != null) {
			System.out.println(node.getData() + " with priority " + node.getPriority());
			node = node.getNext();
		}
		// last node
		System.out.println("Last Node: " + node.getData() +" with priority "+ node.getPriority());
	}
	}

}
