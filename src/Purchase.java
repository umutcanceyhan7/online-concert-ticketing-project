
public class Purchase {
	
	private int id;
	private ICustomer customer;
	private int occupation;
	private int waiting;
	private Purchase next;
	
	
	public Purchase(ICustomer customer, int occupation) {
		this.id = customer.getPurchaseId();
		this.customer = customer;
		this.occupation = occupation;
		this.waiting = 0;
		this.next = null;
	}
	
	public String toString() {
		return "Id: " + this.getId() + ", Occupation: "+ this.getOccupation() +", Waiting: "+ this.getWaiting();
	}
	public String printPurchase() {
		return "Id: " + this.getId() + ", Type: " + this.getCustomer().getType() + ", Seat No: " + this.getCustomer().getSeatNo() + ", Occupation: " + this.getOccupation() + "\n";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ICustomer getCustomer() {
		return customer;
	}
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	public int getOccupation() {
		return occupation;
	}
	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}
	public int getWaiting() {
		return waiting;
	}
	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}
	public Purchase getNext() {
		return next;
	}
	public void setNext(Purchase next) {
		this.next = next;
	}
}
