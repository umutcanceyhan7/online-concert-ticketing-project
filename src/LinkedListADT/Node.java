package LinkedListADT;

public class Node<E> {
	private E data;
	private Integer priority;
	private Node<?> next;
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Node<?> getNext() {
		return next;
	}
	public void setNext(Node<?> next) {
		this.next = next;
	}
}
