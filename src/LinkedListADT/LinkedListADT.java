package LinkedListADT;


public class LinkedListADT<E> {
	Node<E> firstNode;
	
	public boolean isEmpty() {
		if(firstNode == null) {
			return true;
		}
		return false;
	}
	
	public void insert(E data) 
	{
		Node<E> node = new Node<E>();
		node.setData(data);
		// checks if list is empty or not
		if(isEmpty()) {
			firstNode = node;
		}
		else {
			// pull the first node to iterate list
			Node n = firstNode;
			while(n.getNext()!=null) {
				n = n.getNext();
			}
			// assign last node's next, our node that we created at start.
			n.setNext(node);
		}
	}
	public void insertStart(E data) {
		Node<E> node = new Node<E>();
		node.setData(data);
		node.setNext(firstNode);
		firstNode = node;
	}
	
	public void insertAt(int index,E data) {
		if(index == 0) {
			insertStart(data);
		}
		else {
			// create new node
			Node<E> node = new Node<E>();
			node.setData(data);
			
			// iterate the list till the inserting point
			Node<?> n = firstNode;
			for(int i = 0; i<index-1;i++) {
				n = n.getNext();
			}
			// keep the former node's next and assign it to our node's next
			// then assign our node to the former node's next  
				node.setNext(n.getNext());
				n.setNext(node);
		}
	}
	
	public Object delete() {
		if(isEmpty()) {
			return null;
		}
		else if(firstNode.getNext() == null) {
			Node<?> deletedNode = new Node<E>();
			deletedNode = firstNode;
			firstNode = null;
			return deletedNode.getData();
		}
		else {
		Node<?> node = firstNode;
		Node<?> deletedNode = new Node<E>();
		while(node.getNext().getNext() != null) {
			node = node.getNext();
		}
		deletedNode = node.getNext();
		node.setNext(null);
		return deletedNode.getData();
		}
	}
	public Node<E> getHead() {
		return firstNode;
	}
	public E peek() {
		return firstNode.getData();
	}

	public void show() {
		if(firstNode == null) {
			System.out.println("List is empty");
		}
		else {
		Node node = firstNode;
		while(node.getNext() != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		// last node
		System.out.println("Last Node: " + node.getData());
	}
	}
}
