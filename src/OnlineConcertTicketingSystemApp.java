public class OnlineConcertTicketingSystemApp {
	
	
	
	public static final String DAY_1 = "15.05.2021";
	public static final String DAY_2 = "16.05.2021";
	public static final String DAY_3 = "17.05.2021";
	public static final String DAY_4 = "18.05.2021";
	public static final String DAY_5 = "19.05.2021";
	public static final String ITEMS_FILE = "./CENG112_HW3_TicketingPurchase.txt";
	
	public static void main(String[] args) {
		Simulation simulation = new Simulation();
		simulation.run();
		
	}
}
