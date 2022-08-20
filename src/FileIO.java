import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import LinkedListADT.LinkedListADT;
import LinkedListADT.Node;

public class FileIO {
	@SuppressWarnings("unchecked")
	public static <E> LinkedListADT<PurchaseQueue> readFile() { 
		
		// DAYS ARE KEPT IN THIS LINKEDLIST
		
		LinkedListADT<PurchaseQueue> days = new LinkedListADT<PurchaseQueue>();
		PurchaseQueue day1 = new PurchaseQueue("15.05.2021");
		PurchaseQueue day2 = new PurchaseQueue("16.05.2021");
		PurchaseQueue day3 = new PurchaseQueue("17.05.2021");
		PurchaseQueue day4 = new PurchaseQueue("18.05.2021");
		PurchaseQueue day5 = new PurchaseQueue("19.05.2021");
		days.insert(day1); days.insert(day2); days.insert(day3); days.insert(day4); days.insert(day5);
		
		
		File file = new File(OnlineConcertTicketingSystemApp.ITEMS_FILE);
		Scanner  sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] values = line.split(",");
				
				// Creating customer
				
				E tempCustomer = (E) new Customer(
				values[0], // date
				Integer.parseInt(values[1]), // id
				values[2], // type
				values[3], // seat no
				Integer.parseInt(values[4]) // occupation time
				);
				
				// Creating customer's purchase.
				
				Purchase tempPurchase = new Purchase((ICustomer) tempCustomer,Integer.parseInt(values[4]));
				
				// Creating a loop to Add purchases to day queues. 
				
				Node<PurchaseQueue> tempDaysList = days.getHead();
				while(tempDaysList.getData() != null) {
					
					// if date fits make the insert process and break or continue on.
					
					if(tempDaysList.getData().getDate().equals(values[0])) {
						tempDaysList.getData().insert(tempPurchase);
						break;
					}
					else {
						
						tempDaysList = (Node<PurchaseQueue>) tempDaysList.getNext();
					}
				}
				// SMALL LOOP ENDS.
			}
			// BIGGER LOOP ENDS.
			// UPDATES WAITING, TOTAL WAITING TIME. 
			Helper.updateQueues(days);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return days;
			}
}