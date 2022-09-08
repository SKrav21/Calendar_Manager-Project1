/*
 * Class to create the Calendar Object
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/12/2021
 */
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Calendar {
	//data members
	private Event[] eventList;
	private int count;
	/*
	 * Default constructor
	 * intializes eventList at size 100 and count to 0
	 * Adds all the events from the file to the list and increments count after each new addition
	 */
	public Calendar() {
		eventList = new Event[100];
		count = 0;
	}
	public Calendar(String filename) {
		eventList = new Event[100];
		count = 0;
		File file = new File(filename);
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNext()) {
				String eventType = readFile.nextLine();
				if(eventType.equals("appointment")) {
					String date = readFile.next();
					int dCheck = checkDate(date);
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
					String[] dateArr = date.split("/", 3);
					int day = Integer.parseInt(dateArr[1]);
					int month = Integer.parseInt(dateArr[0]);
					int year = Integer.parseInt(dateArr[2]);
					String time = readFile.next();
					int tCheck = checkTime(time);
					if(tCheck == 2) {
						throw new InvalidTimeException("Incorrect Time format");
					}
					else if(tCheck == 3) {
						throw new InvalidTimeException("Invalid hour number");
					}
					else if(tCheck == 4) {
						throw new InvalidTimeException("Invalid minute number");
					}
					String[] timeArr = time.split(":", 3);
					int hour = Integer.parseInt(timeArr[0]);
					int minute = Integer.parseInt(timeArr[1]);
					readFile.nextLine();
					String location = readFile.nextLine();
					String description = readFile.nextLine();
					String contact = readFile.nextLine();
					eventList[count] = new Appointment(description, day, month, year, hour, minute, location, contact );
					count++;
				}
				else if(eventType.equals("meeting")) {
					String date = readFile.next();
					int dCheck = checkDate(date);
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
					String[] dateArr = date.split("/", 3);
					int day = Integer.parseInt(dateArr[1]);
					int month = Integer.parseInt(dateArr[0]);
					int year = Integer.parseInt(dateArr[2]);
					String time = readFile.next();
					int tCheck = checkTime(time);
					if(tCheck == 2) {
						throw new InvalidTimeException("Incorrect Time format");
					}
					else if(tCheck == 3) {
						throw new InvalidTimeException("Invalid hour number");
					}
					else if(tCheck == 4) {
						throw new InvalidTimeException("Invalid minute number");
					}
					String[] timeArr = time.split(":", 3);
					int hour = Integer.parseInt(timeArr[0]);
					int minute = Integer.parseInt(timeArr[1]);
					readFile.nextLine();
					String location = readFile.nextLine();
					String description = readFile.nextLine();
					String host = readFile.nextLine();
					eventList[count] = new Meeting(description, day, month, year, hour, minute, location, host );
					count++;
				}
				else {
					throw new InputMismatchException();
				}
			}
			readFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot open file.");
		}
		catch(InvalidDateException e) {
			System.out.println(e);
		}
		catch(InvalidTimeException e) {
			System.out.println(e);
		}
		catch(InputMismatchException e) {
			System.out.println("First line of event must be either appointment or meeting");
		}
	}
	/*
	 * Method to validate the date
	 * @param the Date String
	 * returns 1 if the date is valid, 2 if the date incorrectly formatted, 3 if the year is incorrect, 4 if the month is incorrect, and 5 if the day is incorrect
	 */
	public int checkDate(String date) {
		int returnCode = 0;
		if(date.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
			String[] dateArr = date.split("/", 3);
			int day = Integer.parseInt(dateArr[1]);
			int month = Integer.parseInt(dateArr[0]);
			int year = Integer.parseInt(dateArr[2]);
			boolean leapYear = false;
			if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
				leapYear = true;
			}
			if(year < 1972 || year > 2030) {
				returnCode = 3;
			}
			else {
				switch (month) {
				case 2:
					if(leapYear) {
						if(day > 29 || day < 1) {
							returnCode = 5;
						}
						else {
							returnCode = 1;
						}
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(day > 30 || day < 1) {
						returnCode = 5;
					}
					else {
						returnCode = 1;
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(day > 31 || day < 1) {
						returnCode = 5;
					}
					else {
						returnCode = 1;
					}
					break;
				default:
					return 4;	
				}
			}
		}
		else {
			returnCode = 2;
		}
		return returnCode;
	}
	/*
	 * Method to validate the time String
	 * @param the Time String
	 * returns 1 if time is valid, 2 if the date is incorrectly formatted, 3 if the hour is incorrect, and 4 if the minute is incorrect
	 */
	public int checkTime(String time) {
		int returnCode = 0;
		if(time.matches("\\d{2}:\\d{2}")) {
			String[] timeArr = time.split(":", 3);
			int hour = Integer.parseInt(timeArr[0]);
			int minute = Integer.parseInt(timeArr[1]);
			if(hour < 0 || hour > 23) {
				returnCode = 3;
			}
			else if (minute < 0 || minute > 59) {
				returnCode = 4;
			}
			else {
				returnCode = 1;
			}
		}
		else {
			returnCode = 2;
		}
		return returnCode;
	}
	/*
	 * method to search the eventList for an event of an event with a matching description
	 * @param d for the description to be searched
	 * returns the event if a matching event is found, otherwise returns null
	 */
	public Event findEvent(String d) {
		int foundIndex = -1;
		for(int i = 0; i < count; i++) {
			if(d.equals(eventList[i].getDescription())) {
				foundIndex = i;
			}
		}
		return eventList[foundIndex];
	}
	/*
	 * Method to add events to the array
	 * @param e for the event to add
	 * returns true if event added
	 * returns false if event not added (such as if the array is full)
	 */
	public boolean addEvent(Event e) {
		boolean eventAdded = false;
		if(count < 100) {
			eventList[count] = e;
			count++;
		}
		return eventAdded;
	}
	public boolean removeEvent(Event e) {
		boolean itemRemoved = false;
		int itemIndex = -1;
		for(int i = 0; i < count; i++) {
			if(eventList[i].equals(e)) {
				itemIndex = i;
			}
		}
		if(itemIndex != -1) {
			for(int i = itemIndex; i < count - 1; i++) {
				eventList[i] = eventList[i + 1];
			}
			count--;
			itemRemoved = true;
		}
		return itemRemoved;
	}
	/*
	 * Method to print out all events
	 */
	public void viewAllEvents() {
		System.out.println(String.format("%-12s\t%s\t\t%s\t%-20s\t%-18s\t%-12s", "Type", "Date", "Time", "Location", "Description", "Host/Contact"));
		for(int i = 0; i < count; i++) {
			System.out.println(eventList[i].toString());
		}
	}
	/*
	 * Method to sort the Array by the on their date and time
	 */
	public void sortEvent() {
		Arrays.sort(eventList, 0, count);
	}
	/*
	 * Method to save the array to the txt file
	 * @param a string for the name of the text file
	 */
	public void saveToFile(String filename) {
		try {
			PrintWriter writeFile = new PrintWriter(filename);
			for(int i = 0; i < count; i++) {
				if(eventList[i].toString().charAt(0) == 'A') {
					Appointment app = (Appointment) eventList[i];
					writeFile.println("appointment");
					writeFile.println(app.getDate());
					writeFile.println(app.getTime());
					writeFile.println(app.getLocation());
					writeFile.println(app.getDescription());
					writeFile.println(app.getContact());
				}
				else if(eventList[i].toString().charAt(0) == 'M') {
					Meeting meet = (Meeting) eventList[i];
					writeFile.println("meeting");
					writeFile.println(meet.getDate());
					writeFile.println(meet.getTime());
					writeFile.println(meet.getLocation());
					writeFile.println(meet.getDescription());
					writeFile.println(meet.getHost());
				}
			}
			writeFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
	}
}