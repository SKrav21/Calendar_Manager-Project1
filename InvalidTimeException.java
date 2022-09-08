/*
 * Class to create the Invalid Time Exception
 * @author	Steven Kravitz
 * @version	1.1
 * created 3/6/2021
 * last edited 3/12/2021
 */
public class InvalidTimeException extends Exception {
	/*
	 * Default Constructor for InvalidTimeException
	 */
	public InvalidTimeException() {
		super();
	}
	/*
	 * Constructor for InvalidTimeException with one constructor for the message
	 */
	public InvalidTimeException(String message) {
		super(message);
	}
}
