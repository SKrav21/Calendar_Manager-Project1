/*
 * Class to create the Meeting Entity
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/11/2021
 */
public class Meeting extends Event {
	//data members
	private String host;
	/*
	 * Default Constructor
	 * Sets host to "none"
	 */
	public Meeting() {
		super();
		host = "none";
	}
	/*
	 * Constructor with 8 parameters
	 * @param description for the summary of the Meeting
	 * @param day for the day of the Meeting
	 * @param month for the month of the Meeting
	 * @param year for the year of the Meeting
	 * @param hour for the hour of the Meeting
	 * @param minute for the minute of the Meeting
	 * @param location for the location of the Meeting
	 * @param host for the host of the Meeting
	 */
	public Meeting(String description, int day, int month, int year, int hour, int minute, String location, String host) {
		super(description, day, month, year, hour, minute, location);
		this.host = host;
	}
	/*
	 * Getter for host
	 * returns host
	 */
	public String getHost() {
		return host;
	}
	/*
	 * Setter for host
	 * @param contact for host
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/*
	 * Method to return the information of the Meeting in a formatted String
	 */
	@Override
	public String toString() {
		return String.format("%-12s\t%-12s\t%-12s","Meeting", super.toString(), host);
	}
}