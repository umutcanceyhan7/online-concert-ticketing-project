import LinkedListADT.LinkedListADT;
import LinkedListADT.Node;

public class Helper {
	
	// Display the day
	public void displayTheDay(String date) {
		System.out.println(displayTicketInfo(date));
		System.out.println("\nRECENT STATE OF CONCERT AVENUE\n");
		showConcertAvenue(date);
		System.out.println("\n");
	}
	
	
	
	//**********************************************************************************************************************
		// SHOWS THE GIVEN AVENUE'S STATUS
		public static void showConcertAvenue(String date) {
			LinkedListADT<PurchaseQueue> days = FileIO.readFile();
			LinkedListADT<?> concertAvenue = updateSoldSeats(createConcertAvenue(), days, date);
			LinkedListADT<?> concertAvenue2 = updateUnsoldSeats(concertAvenue);  
			printAvenue(concertAvenue2);
		}
	
	public static String displayTicketInfo(String date) {
		LinkedListADT<PurchaseQueue> days = FileIO.readFile();
		// Created temporaryDays Node
		Node<PurchaseQueue> tempDays = days.getHead();
		// Compare dates and find searched date.
		while(tempDays != null) {
			if(tempDays.getData().getDate().equals(date)) {
				break;
			}
			// nextDay
						tempDays = (Node<PurchaseQueue>) tempDays.getNext();
					}
			
			
		return "Day : " + tempDays.getData().getDate() 
			+"\nPurchase Queue : \n" + printPurchaseQueue(date)
			+"Sold ticket number : " + tempDays.getData().getQueueLength()
			+"\nTotal waiting time : " + tempDays.getData().getTotalWaitingTime()
			+"\nAverage waiting time : " + (tempDays.getData().getTotalWaitingTime() / tempDays.getData().getQueueLength())
			+ printTicketInfo(tempDays.getData().getDate());	
	}
	
	public static String printTicketInfo(String date) {
			// Brings the actual day's queue
			Node<PurchaseQueue> day = checkDate(date);
			// Assigm queue to a variable
			PurchaseQueue queue = day.getData();
			// Updates Customer's number and waiting information according to their type
			updateTicketTypeInfo(day);
			// Fixes by Zero exception
			byZeroSolution(date);	
				 
			return "\nTotal sold GOLD tickets : " + queue.getGoldCustomerNumber()
					+"\nTotal sold SILVER tickets : " + queue.getSilverCustomerNumber()
					+"\nTotal sold BRONZE tickets : " + queue.getBronzeCustomerNumber()
					+"\nTotal sold FREE tickets : " + queue.getFreeCustomerNumber()
					+"\nTotal waiting time for GOLD : " + queue.getGoldCustomerWaiting()
					+"\nAverage waiting time for GOLD : " + queue.getAverageGold()
					+"\nTotal waiting time for SILVER : " + queue.getSilverCustomerWaiting()
					+"\nAverage waiting time for SILVER : " + queue.getAverageSilver()
					+"\nTotal waiting time for BRONZE : " + queue.getBronzeCustomerWaiting()
					+"\nAverage waiting time for BRONZE : " + queue.getAverageBronze()
					+"\nTotal waiting time for FREE : " + queue.getFreeCustomerWaiting()
					+"\nAverage waiting time for FREE : " + queue.getAverageFree();
				
	}
	
	public static void updateTicketTypeInfo(Node<PurchaseQueue> day) {
		Purchase tempPurchase = day.getData().getHead();
		PurchaseQueue queue = day.getData();
		while(tempPurchase != null) {
			
			if(tempPurchase.getCustomer().getType().equals("GOLD")) {
				
				queue.setGoldCustomerNumber(queue.getGoldCustomerNumber() + 1);
				queue.setGoldCustomerWaiting(queue.getGoldCustomerWaiting() + tempPurchase.getWaiting());
			}
			else if(tempPurchase.getCustomer().getType().equals("SILVER")) {
				
				queue.setSilverCustomerNumber(queue.getSilverCustomerNumber() + 1);
				queue.setSilverCustomerWaiting(queue.getSilverCustomerWaiting() + tempPurchase.getWaiting());
			}
			else if(tempPurchase.getCustomer().getType().equals("BRONZE")) {
				
				queue.setBronzeCustomerNumber(queue.getBronzeCustomerNumber() + 1);
				queue.setBronzeCustomerWaiting(queue.getBronzeCustomerWaiting() + tempPurchase.getWaiting());
			}
			else if(tempPurchase.getCustomer().getType().equals("FREE")) {
				queue.setFreeCustomerNumber(queue.getFreeCustomerNumber() + 1);
				queue.setFreeCustomerWaiting(queue.getFreeCustomerWaiting() + tempPurchase.getWaiting());
			}
			else {
				System.out.println("Wrong customer type. There is no customer type like this.");
			}
			
			// next purchase
			tempPurchase = tempPurchase.getNext();
			}
		
	}
	
	
	// Checks if customer number is zero sets average to customerWaiting else divides it to customer number
	public static void byZeroSolution(String date) {
		
		Node<PurchaseQueue> day = checkDate(date);
		
		PurchaseQueue queue = day.getData();
		// / by zero solution
		// if customer number is zero sets average to customerWaiting else divides it to customer number
		if(queue.getGoldCustomerNumber() == 0 ) {
			queue.setAverageGold(queue.getGoldCustomerWaiting()); 
		}
		else {
			queue.setAverageGold(queue.getGoldCustomerWaiting()/queue.getGoldCustomerNumber()); 
		}
		if(queue.getSilverCustomerNumber() == 0) {
			queue.setAverageSilver(queue.getSilverCustomerWaiting());
		}
		else {
			queue.setAverageSilver(queue.getSilverCustomerWaiting()/queue.getSilverCustomerNumber());
		}
		if(queue.getBronzeCustomerNumber() == 0) {
			queue.setAverageBronze(queue.getBronzeCustomerWaiting());
		}
		else {
			queue.setAverageBronze(queue.getBronzeCustomerWaiting()/queue.getBronzeCustomerNumber());
		}
		if(queue.getFreeCustomerNumber() == 0) {
			queue.setAverageFree(queue.getFreeCustomerWaiting());
		}
		else {
			queue.setAverageFree(queue.getFreeCustomerWaiting()/queue.getFreeCustomerNumber());
		}
	
		// / by zero solution ends
	}
	
	public static Node<PurchaseQueue> checkDate(String date) {
		LinkedListADT<PurchaseQueue> days = FileIO.readFile();
		// Created temporaryDays Node
		Node<PurchaseQueue> tempDays = days.getHead();
		// Compare dates and find searched date.
			while(tempDays != null) {
				if(tempDays.getData().getDate().equals(date)) {
					break;
				}
				// nextDay
				tempDays = (Node<PurchaseQueue>) tempDays.getNext();
			}
			return tempDays;
	}
	
	public static String printPurchaseQueue(String date) {
		String purchaseQueue = "";
		Node<PurchaseQueue> day = checkDate(date);
			
			
			Purchase tempPurchase = day.getData().getHead();
			while(tempPurchase != null) {
				purchaseQueue = purchaseQueue.concat(tempPurchase.printPurchase());
				
				tempPurchase = tempPurchase.getNext();
			}
			return purchaseQueue;
	}
	
	
	
	
	
	
	
	
	// CREATES THE AVENUE
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static LinkedListADT<LinkedListADT<String>> createConcertAvenue() {
		LinkedListADT concertAvenue = new LinkedListADT();
		LinkedListADT A = new LinkedListADT(); A.insertStart("A");
		LinkedListADT B = new LinkedListADT(); B.insertStart("B");
		LinkedListADT C = new LinkedListADT(); C.insertStart("C");
		LinkedListADT D = new LinkedListADT(); D.insertStart("D");
		LinkedListADT E = new LinkedListADT(); E.insertStart("E");
		concertAvenue.insert(A); concertAvenue.insert(B); concertAvenue.insert(C); concertAvenue.insert(D);	concertAvenue.insert(E);
		
		Node<LinkedListADT> tempAvenue = concertAvenue.getHead();
		while(tempAvenue != null) {
			LinkedListADT<String> tempSeat = tempAvenue.getData();
			int i = 1;
			for(i =1 ; i<6; i++) {
				tempSeat.insert(tempSeat.peek() +i);
			}
			i = 1;
			
			//next seat
			tempAvenue = (Node<LinkedListADT>) tempAvenue.getNext();
		}
		return concertAvenue;
	}
	
	// PRINTS GIVEN AVENUE
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void printAvenue(LinkedListADT concertAvenue) {
		Node<LinkedListADT> tempAvenue = concertAvenue.getHead();
		while(tempAvenue != null) {
			LinkedListADT<String> tempSeat = tempAvenue.getData();
			Node<String> tempSeatNo = tempSeat.getHead();
			// Prints The Row
			while(tempSeatNo != null) {
				// if it is the last element of the row make carriage return.
				if(tempSeatNo.getNext() == null) {
					System.out.print(tempSeatNo.getData()+"\n");
					break;
				}
				System.out.print(tempSeatNo.getData()+" ");
				
				
				tempSeatNo = (Node<String>) tempSeatNo.getNext();
			}
			//next seat
			tempAvenue = (Node<LinkedListADT>) tempAvenue.getNext();
		}
	}
	
	
	//**********************************************************************************************************************
	// UPDATES SOLD SEATS
	// It turns to S the seats which have sold.
	@SuppressWarnings("unchecked")
	private static LinkedListADT<?> updateSoldSeats(LinkedListADT concertAvenue,LinkedListADT<PurchaseQueue> days, String date) {
			
					Node<PurchaseQueue> day = checkDate(date);
				
					// Take purchase to compare seats
					Purchase tempPurchase = day.getData().getHead();
					while(tempPurchase != null) {
						String customerSeatNo = tempPurchase.getCustomer().getSeatNo();
						
						// Boolean to exit from 2 loops at the same time
						boolean compare = false;
						
						
						// Seats kept here
						Node<LinkedListADT> tempAvenue = concertAvenue.getHead();
						while(tempAvenue != null && compare == false) {
							LinkedListADT<String> tempRow = tempAvenue.getData();
							Node<String> tempSeatNo = tempRow.getHead();
							
							
							//Compare seat Letters and when you find exit from loop and outer loop.
							while(tempSeatNo != null ) {
								if(tempSeatNo.getData().equals(customerSeatNo)) {
									tempSeatNo.setData("S");
									compare = true;
									break;
								}
								tempSeatNo = (Node<String>) tempSeatNo.getNext();
							}
							
							tempAvenue = (Node<LinkedListADT>) tempAvenue.getNext();
						}
						
						// next purchase
						tempPurchase = tempPurchase.getNext();
					}

							
		return concertAvenue;
		}
	
	
	//**********************************************************************************************************************
	// UPDATES UNSOLD SEATS
	@SuppressWarnings("unchecked")
	private static LinkedListADT<?> updateUnsoldSeats(LinkedListADT concertAvenue) {
						// Seats kept here
						Node<LinkedListADT> tempAvenue = concertAvenue.getHead();
						while(tempAvenue != null) {
							LinkedListADT<String> tempRow = tempAvenue.getData();
							Node<String> tempSeatNo = tempRow.getHead();
							//Compare seat Letters and when you find exit from loop and outer loop.
							while(tempSeatNo != null ) {
								// If seat is S,A,B,C,D,E do not change else change to U
								if(!tempSeatNo.getData().equals("S") && !tempSeatNo.getData().equals("A") && !tempSeatNo.getData().equals("B") && !tempSeatNo.getData().equals("C") && !tempSeatNo.getData().equals("D") && !tempSeatNo.getData().equals("E")) {
									tempSeatNo.setData("U");
								}
								tempSeatNo = (Node<String>) tempSeatNo.getNext();
							}
							
							tempAvenue = (Node<LinkedListADT>) tempAvenue.getNext();
						}
	
		return concertAvenue;
		}
	// Updates Queue Values
	// TOTAL WAITING TIME AND WAITING TIME CHANGES FROM HERE
	public static void updateQueues(LinkedListADT<PurchaseQueue> queueList) {
		// Checks the list is empty or not
		if(queueList.peek() == null) {
			System.out.println("List is empty");
		}
		// Iterates all queues and purchases 
		else {
			Node<PurchaseQueue> tempQueueList = queueList.getHead();
			while(tempQueueList != null) {
				
				PurchaseQueue tempQueue = tempQueueList.getData();
				Purchase tempPurchase =  tempQueue.getHead();
				
					while(tempPurchase != null) {
						// If purchase is head purchase only update queueLength and total waiting do not change waiting 
						if(tempQueue.getHead() == tempPurchase) {
							tempQueue.setQueueLength(tempQueue.getQueueLength() + 1);
							tempQueue.setTotalWaitingTime(tempQueue.getTotalWaitingTime() + tempPurchase.getOccupation());
							
							tempPurchase = tempPurchase.getNext();
						}
						
						else if(tempPurchase.getNext() == null) {
							tempQueue.setQueueLength(tempQueue.getQueueLength() + 1);
							tempPurchase.setWaiting(tempQueue.getTotalWaitingTime());
							
							tempPurchase = tempPurchase.getNext();
						}
						// Else update queue length, waiting time and also purchase waiting time
						else {
						tempPurchase.setWaiting(tempQueue.getTotalWaitingTime());
						tempQueue.setTotalWaitingTime(tempQueue.getTotalWaitingTime() + tempPurchase.getOccupation());
						tempQueue.setQueueLength(tempQueue.getQueueLength() + 1);

						// pass next purchase
						tempPurchase = tempPurchase.getNext();
					
						}
					}
					// SMALL LOOP ENDS
					// pass next queue
					tempQueueList = (Node<PurchaseQueue>) tempQueueList.getNext();
					
				}
			// BIGGER LOOP ENDS
			}
		}
	
	
	
	public static void printPurchases(LinkedListADT<PurchaseQueue> queueList) {
		Node<PurchaseQueue> tempQueueList = queueList.getHead();
		while(tempQueueList != null) {
			// Print date
			System.out.println(tempQueueList.getData().getDate());
			Purchase tempPurchase = tempQueueList.getData().getHead();
			while(tempPurchase != null) {
				// Print purchase
				System.out.println(tempPurchase.toString());
				// next purchase
				tempPurchase = tempPurchase.getNext();
				}
			
			tempQueueList = (Node<PurchaseQueue>) tempQueueList.getNext();
		}
	}
	
	public static void printCustomers(LinkedListADT<PurchaseQueue> queueList) {
		Node<PurchaseQueue> tempQueueList = queueList.getHead();
		while(tempQueueList != null) {
			// Print date
			System.out.println(tempQueueList.getData().getDate());
			Purchase tempPurchase = tempQueueList.getData().getHead();
			while(tempPurchase != null) {
				// Print purchase
				System.out.println(tempPurchase.getCustomer().toString());
				
				// next purchase
				tempPurchase = tempPurchase.getNext();
				}
			
			tempQueueList = (Node<PurchaseQueue>) tempQueueList.getNext();
		}
	}
	
	
	
	
}