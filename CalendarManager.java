/*
 * Class to create the Calendar Manager
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/12/2021
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
public class CalendarManager {
	/*
	 * Main method
	 * @param args for the arguments of the main method
	 * return void
	 */
	public static void main(String[] args) {
		Calendar myCalendar = new Calendar("events.txt");
		int menuChoice = 0;
		do {
			printMenu();
			Scanner scanner = new Scanner(System.in);
			try {
				menuChoice = scanner.nextInt();
				switch(menuChoice) {
				case 1:
					System.out.println("Enter the description you wish to search for");
					scanner.nextLine();
					String d = scanner.nextLine();
					try {
						Event e = myCalendar.findEvent(d);
						System.out.println("That event was found");
						System.out.println(e.toString());
					}
					catch(ArrayIndexOutOfBoundsException e2) {
						System.out.println("That event was not found");
					}
					break;
				case 2:
					boolean eventAdded = false;
					System.out.println("Enter the type of event: appointment or meeting");
					String eType = scanner.next();
					if(!(eType == "appointment" || eType == "meeting")) {
						throw new InputMismatchException();
					}
					System.out.println("Enter the date of the event mm/dd/yyyy");
					String eDate = scanner.next();
					int dCheck = myCalendar.checkDate(eDate);
					if (dCheck == 2){
						throw new InvalidDateException("Invalid date format");
					}
					else if (dCheck == 3){
						throw new InvalidDateException("Invalid Year number");
					}
					else if (dCheck == 4){
						throw new InvalidDateException("Invalid Month number");
					}
					else if (dCheck == 5){
						throw new InvalidDateException("Invalid Day number");
					}
					String[] dateArr = eDate.split("/", 3);
					int day = Integer.parseInt(dateArr[1]);
					int month = Integer.parseInt(dateArr[0]);
					int year = Integer.parseInt(dateArr[2]);
					System.out.println("Enter the time of the event hh:mm");
					String eTime = scanner.next();
					int tCheck = myCalendar.checkTime(eTime);
					if(tCheck == 2) {
						throw new InvalidTimeException("Incorrect Time format");
					}
					else if(tCheck == 3) {
						throw new InvalidTimeException("Invalid hour number");
					}
					else if(tCheck == 4) {
						throw new InvalidTimeException("Invalid minute number");
					}
					String[] timeArr = eTime.split(":", 3);
					int hour = Integer.parseInt(timeArr[0]);
					int minute = Integer.parseInt(timeArr[1]);
					scanner.nextLine();
					System.out.println("Enter the location of the event");
					String eLocation = scanner.nextLine();
					System.out.println("Enter the description of the event");
					String eDescription = scanner.nextLine();
					if(eType == "appointment") {
						System.out.println("Enter the contact of the appointment");
						String eContact = scanner.nextLine();
						Appointment newApp = new Appointment(eDescription, day, month, year, hour, minute, eLocation, eContact);
						eventAdded = myCalendar.addEvent(newApp);
					}
					else {
						System.out.println("Enter the host of the meeting");
						String eHost = scanner.nextLine();
						Meeting newMeet = new Meeting(eDescription, day, month, year, hour, minute, eLocation, eHost);
						eventAdded = myCalendar.addEvent(newMeet);
					}
					if(eventAdded) {
						myCalendar.saveToFile("events.txt");
						System.out.println("event Added");
					}
					else {
						System.out.println("failed to add event");
					}
					break;
				case 3:
					boolean eventRemoved = false;
					String remD = scanner.nextLine();
					System.out.println("Enter the description of the event");
					try {
						Event remE = myCalendar.findEvent(remD);
						eventRemoved = myCalendar.removeEvent(remE);
					}
					catch(ArrayIndexOutOfBoundsException e2) {
						System.out.println("that event does not exist");
					}
						myCalendar.saveToFile("events.txt");
					break;
				case 4:
					myCalendar.viewAllEvents();
					break;
				case 5:
					myCalendar.sortEvent();
					myCalendar.saveToFile("events.txt");
					break;
				case 6:
					System.out.println("goodbye");
					break;
				default:
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input");
			}
			catch(InvalidDateException e) {
				System.out.println(e);
			}
			catch(InvalidTimeException e) {
				System.out.println(e);
			}
		}while(menuChoice != 6);
	}
	/*
	 * Method to print out the main menu
	 */
	public static void printMenu() {
		System.out.println("Select an operation:\r\n"
				+ "1: Find an event\r\n"
				+ "2: Add a new event\r\n"
				+ "3: Remove an event\r\n"
				+ "4: View all events\r\n"
				+ "5: Sort event\r\n"
				+ "6: Exit");
	}

}
