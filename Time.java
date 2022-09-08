/*
 * Class to create the Time Entity
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/11/2021
 */
public class Time implements Comparable<Time> {
	//data members
	private int hour;
	private int minute;
	/*
	 * Default class
	 * minute and hour are set to 0
	 */
	public Time() {
		minute = 0;
		hour = 0;
	}
	/*
	 * Constuctor with two parameters
	 * @param minute for the number of minutes past the hour
	 * @param hour for the hour of the day
	 */
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	/*
	 * Getter for the minute
	 * no parameters
	 * returns the minute
	 */
	public int getMinute() {
		return minute;
	}
	/*
	 * Getter for the hour
	 * no parameters
	 * returns the hou4
	 */
	public int getHour() {
		return hour;
	}
	/*
	 * Setter for the minute
	 * @param minute for the minute
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
	/*
	 * Setter for the hour
	 * @param hou4 for the hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	/*
	 * Method to return the data of the class in a formatted String
	 */
	@Override
	public String toString() {
		return String.format("%02d:%02d", hour, minute);
	}
	/*
	 * Method for comparing dates
	 * returns 0 if times are equal
	 * returns 1 if original time is later
	 * returns -1 if new time is later
	 */
	public int compareTo(Time tm) {
		if(hour > tm.getHour()) {
			return 1;
		}
		else if (hour < tm.getHour()) {
			return -1;
		}
		else {
			if(minute > tm.getMinute()) {
				return 1;
			}
			else if(minute < tm.getMinute()) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}