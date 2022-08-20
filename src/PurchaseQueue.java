
public class PurchaseQueue {
	private Purchase head;
	private int queueLength;
	private int totalWaitingTime;
	private String date;
	private PurchaseQueue next;
	private int goldCustomerNumber; private	int goldCustomerWaiting;
	private int silverCustomerNumber; private int silverCustomerWaiting;
	private int bronzeCustomerNumber; private int bronzeCustomerWaiting;
	private int freeCustomerNumber; private	int freeCustomerWaiting;
	private int averageGold;
	private int averageSilver;
	private int averageBronze;
	private int averageFree;
	
	
	public PurchaseQueue(String date) {
		this.head = null;
		this.queueLength = 0;
		this.totalWaitingTime = 0;
		this.date = date;
		this.next = null;
	}
	public void insert(Purchase T) {
		if(head == null) {
			setHead(T);
			
		}
		else {
			if(head.getCustomer().getPriority() > T.getCustomer().getPriority()) {
				T.setNext(head);
				setHead(T);
			}
			else {
				Purchase tempPurchase = this.head;
				// If there is next purchase and this purchase is has higher priority continue to loop or exit.
				while(tempPurchase.getNext() != null && tempPurchase.getNext().getCustomer().getPriority() <= T.getCustomer().getPriority()) {
					tempPurchase = tempPurchase.getNext();
				}
				// Add the purchase to the queue
				T.setNext(tempPurchase.getNext());
				tempPurchase.setNext(T);
			}
		}
	}
	
	public Purchase remove() {
		Purchase tempPurchase = this.getHead();
		Purchase deletedPurchase = tempPurchase;
		this.setHead(tempPurchase.getNext());
		return deletedPurchase;
	}
	public boolean isEmpty() {
		Purchase tempPurchase = this.getHead();
		if(tempPurchase == null) {
			return true;
		}
		return false;
	}
	public boolean clear() {
		this.setHead(null);
		Purchase tempPurchase = this.getHead();
		if(tempPurchase == null) {
			return true;
		}
		return false;
	}
	// Prints Queues informations 
	public String toString() {
		return "Date: "+ getDate() + "\nHead: " + getHead() + "\nQueue Length: " + getQueueLength() + "\nTotal Waiting Time: " + getTotalWaitingTime();
	}
	
	public Purchase getHead() {
		return head;
	}
	public void setHead(Purchase head) {
		this.head = head;
	}
	public int getQueueLength() {
		return queueLength;
	}
	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}
	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}
	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public PurchaseQueue getNext() {
		return next;
	}
	public void setNext(PurchaseQueue next) {
		this.next = next;
	}
	public int getAverageGold() {
		return averageGold;
	}
	public void setAverageGold(int averageGold) {
		this.averageGold = averageGold;
	}
	public int getAverageSilver() {
		return averageSilver;
	}
	public void setAverageSilver(int averageSilver) {
		this.averageSilver = averageSilver;
	}
	public int getAverageBronze() {
		return averageBronze;
	}
	public void setAverageBronze(int averageBronze) {
		this.averageBronze = averageBronze;
	}
	public int getAverageFree() {
		return averageFree;
	}
	public void setAverageFree(int averageFree) {
		this.averageFree = averageFree;
	}

	public int getGoldCustomerNumber() {
		return goldCustomerNumber;
	}
	public void setGoldCustomerNumber(int goldCustomerNumber) {
		this.goldCustomerNumber = goldCustomerNumber;
	}
	public int getGoldCustomerWaiting() {
		return goldCustomerWaiting;
	}
	public void setGoldCustomerWaiting(int goldCustomerWaiting) {
		this.goldCustomerWaiting = goldCustomerWaiting;
	}
	public int getSilverCustomerNumber() {
		return silverCustomerNumber;
	}
	public void setSilverCustomerNumber(int silverCustomerNumber) {
		this.silverCustomerNumber = silverCustomerNumber;
	}
	public int getSilverCustomerWaiting() {
		return silverCustomerWaiting;
	}
	public void setSilverCustomerWaiting(int silverCustomerWaiting) {
		this.silverCustomerWaiting = silverCustomerWaiting;
	}
	public int getBronzeCustomerNumber() {
		return bronzeCustomerNumber;
	}
	public void setBronzeCustomerNumber(int bronzeCustomerNumber) {
		this.bronzeCustomerNumber = bronzeCustomerNumber;
	}
	public int getBronzeCustomerWaiting() {
		return bronzeCustomerWaiting;
	}
	public void setBronzeCustomerWaiting(int bronzeCustomerWaiting) {
		this.bronzeCustomerWaiting = bronzeCustomerWaiting;
	}
	public int getFreeCustomerNumber() {
		return freeCustomerNumber;
	}
	public void setFreeCustomerNumber(int freeCustomerNumber) {
		this.freeCustomerNumber = freeCustomerNumber;
	}
	public int getFreeCustomerWaiting() {
		return freeCustomerWaiting;
	}
	public void setFreeCustomerWaiting(int freeCustomerWaiting) {
		this.freeCustomerWaiting = freeCustomerWaiting;
	}
}
