/*
 * Class to create the Date Entity
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/11/2021
 */
public class Date implements Comparable<Date> {
	//data members
	private int day;
	private int month;
	private int year;
	/*
	 * default constuctor
	 * no parameters
	 * sets day, month, and year to 0
	 */
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	/*
	 * Constructor with three parameters
	 * @param day for the day of the date
	 * @param month for the month of the date
	 * @param year for the year of the date
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	/*
	 * Getter for day
	 * @param none
	 * returns day
	 */
	public int getDay() {
		return day;
	}
	/*
	 * Getter for month
	 * @param none
	 * returns month
	 */
	public int getMonth() {
		return month;
	}
	/*
	 * Getter for year
	 * @param none
	 * returns year
	 */
	public int getYear() {
		return year;
	}
	/*
	 * Setter for day
	 * @param the day
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/*
	 * Setter for month
	 * @param the month
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/*
	 * Setter for year
	 * @param the year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/*
	 * Method for returning the data in a formatted String
	 */
	@Override
	public String toString() {
		return String.format("%02d/%02d/%02d", month, day, year);
	}
	/*
	 * Method for comparing dates
	 * returns 0 if dates are equal
	 * returns 1 if original date is later
	 * returns -1 if new date is later
	 */
	public int compareTo(Date dt) {
		if(year > dt.year) {
			return 1;
		}
		else if(year < dt.year) {
			return -1;
		}
		else {
			if(month > dt.month) {
				return 1;
			}
			else if(month < dt.month) {
				return -1;
			}
			else {
				if(day > dt.day) {
					return 1;
				}
				else if(day < dt.day) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
}