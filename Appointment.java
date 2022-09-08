/*
 * Class to create the Appointment Entity
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/11/2021
 */
public class Appointment extends Event {
	//data members
	private String contact;
	/*
	 * Default Constructor
	 * Sets contact to "none"
	 */
	public Appointment() {
		super();
		contact = "none";
	}
	/*
	 * Constructor with 8 parameters
	 * @param description for the summary of the appointment
	 * @param day for the day of the appointment
	 * @param month for the month of the appointment
	 * @param year for the year of the appointment
	 * @param hour for the hour of the appointment
	 * @param minute for the minute of the appointment
	 * @param location for the location of the appointment
	 * @param contact for the contact of the appointment
	 */
	public Appointment(String description, int day, int month, int year, int hour, int minute, String location, String contact) {
		super(description, day, month, year, hour, minute, location);
		this.contact = contact;
	}
	/*
	 * Getter for Contact
	 * returns contact
	 */
	public String getContact() {
		return contact;
	}
	/*
	 * Setter for contact
	 * @param contact for contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/*
	 * Method to return the information of the Appointment in a formatted String
	 */
	@Override
	public String toString() {
		return String.format("%-12s\t%s\t%-12s","Appointment", super.toString(), contact);
	}
}