/*
 * Class to create the Invalid Date Exception
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/12/2021
 */
public class InvalidDateException extends Exception {
	/*
	 * Default Constructor for InvalidDateException
	 */
	public InvalidDateException() {
		super();
	}
	/*
	 * Constructor for InvalidDateException with one constructor for the message
	 */
	public InvalidDateException(String message) {
		super(message);
	}
}
