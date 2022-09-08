/*
 * Class to create the Abstract Event Class
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/11/2021
 */
public abstract class Event implements Comparable<Event> {
	//data members
	String description;
	Date date;
	Time time;
	String location;
	/*
	 * Default class
	 * Initializes default constructors of date and time
	 * Sets description and location to "none"
	 */
	protected Event() {
		description = "none";
		date = new Date();
		time = new Time();
		location = "none";
	}
	/*
	 * Constructor with 7 parameters
	 * @param description for the summary of the event
	 * @param day for the day of the event
	 * @param month for the month of the event
	 * @param year for the year of the event
	 * @param hour for the hour of the event
	 * @param minute for the minute of the event
	 * @param location for the location of the event
	 */
	protected Event(String description, int day, int month, int year, int hour, int minute, String location) {
		this.description  = description;
		this.date = new Date(day, month, year);
		this.time = new Time(hour, minute);
		this.location = location;
	}
	/*
	 * Getter for Description
	 * returns the description
	 */
	public String getDescription() {
		return description;
	}
	/*
	 * Getter for Date
	 * returns the date
	 */
	public Date getDate() {
		return date;
	}
	/*
	 * Getter for time
	 * returns the time
	 */
	public Time getTime() {
		return time;
	}
	/*
	 * Getter for the location
	 * returns the location
	 */
	public String getLocation() {
		return location;
	}
	/*
	 * Setter for the description
	 * @param the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * Setter for the date
	 * @param year for the year of the date
	 * @param month for the month of the date
	 * @param day for the day of the date
	 */
	public void setDate(int year, int month, int day) {
		date.setYear(year);
		date.setMonth(month);
		date.setDay(day);
	}
	/*
	 * Setter for the time
	 * @param hour for the hour
	 * @param minute for the minute
	 */
	public void setTime(int hour, int minute) {
		time.setHour(hour);
		time.setMinute(minute);
	}
	/*
	 * Setter for the location of the 
	 * @param location for the location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/*
	 * Method to return the information of the class in a formatted String
	 */
	@Override
	public String toString() {
		return String.format("%s\t%s\t%-20s\t%-18s", date.toString(), time.toString(), location, description);
	}
	/*
	 * Method to see if methods have the same description
	 * @param description of the event that this event is being compared to
	 * Returns true if the descriptions are the same and false if they are not
	 */
	@Override
	public boolean equals(Object obj) {
		Event ev = (Event) obj;
		boolean equal;
		if (description == ev.getDescription()) {
			equal = true;
		}
		else {
			equal = false;
		}
		return equal;
	}
	/*
	 * Method to comapare which event preceeded the other
	 * returns 0 if the events happened at the same time
	 * returns 1 if this event came later
	 * returns -1 if the other event came later
	 */
	public int compareTo(Event ev) {
		if(date.compareTo(ev.getDate()) == 1) {
			return 1;
		}
		else if(date.compareTo(ev.getDate()) == -1) {
			return -1;
		}
		else {
			if(time.compareTo(ev.getTime()) == 1) {
				return 1;
			}
			else if(time.compareTo(ev.getTime()) == -1) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}