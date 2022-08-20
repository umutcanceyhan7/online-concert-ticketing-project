
public class Customer implements ICustomer {
	private String date;
	private int purchaseId;
	private String type;
	private String seatNo;
	private int occupationTime;
	private int priority;
	// Constructor
	public Customer(String date, int purchaseId, String type, String seatNo, int occupationTime) {
		this.date = date;
		this.purchaseId = purchaseId;
		this.type = type;
		this.seatNo = seatNo;
		this.occupationTime = occupationTime;
		// Creates priorities according to type
		updatePriorities();
	}
	
	// Creates priorities according to type
	public void updatePriorities() {
		if(this.type.equals("GOLD")) {
			this.setPriority(1);
		}
		else if(this.type.equals("SILVER")) {
			this.setPriority(2);
		}
		else if(this.type.equals("BRONZE")) {
			this.setPriority(3);
		}
		else if(this.type.equals("FREE")) {
			this.setPriority(4);
		}
	}
	
	public String toString() {
		return "Date: " + this.getDate() + ", ID: " + this.getPurchaseId() + ", Type: " + this.getType() + ", Seat: " + this.getSeatNo() + ", Occupation Time: "+ this.getOccupationTime() + ", Priority: "+ this.getPriority();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	public String getSeatNo() {
		return seatNo;
	}
	public void setseatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	
	public int getOccupationTime() {
		return occupationTime;
	}
	public void setOccupationTime(int occupationTime) {
		this.occupationTime = occupationTime;
	}
	

	public int getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
