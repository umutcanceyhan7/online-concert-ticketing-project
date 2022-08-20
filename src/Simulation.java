
public class Simulation {
	
	public void run() {
		Helper helper = new Helper();
		System.out.println("Welcome to simulation of a concert's 5 days ticket purchasing system.");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("------------DAY 1-------------------");
		helper.displayTheDay(OnlineConcertTicketingSystemApp.DAY_1);
		System.out.println("------------DAY 2-------------------");
		helper.displayTheDay(OnlineConcertTicketingSystemApp.DAY_2);
		System.out.println("------------DAY 3-------------------");
		helper.displayTheDay(OnlineConcertTicketingSystemApp.DAY_3);
		System.out.println("------------DAY 4-------------------");
		helper.displayTheDay(OnlineConcertTicketingSystemApp.DAY_4);
		System.out.println("------------DAY 5-------------------");
		helper.displayTheDay(OnlineConcertTicketingSystemApp.DAY_5);
		
	}
}
