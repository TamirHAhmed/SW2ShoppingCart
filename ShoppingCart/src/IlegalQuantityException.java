
public class IlegalQuantityException extends java.lang.RuntimeException {

	private String message;

	/**
	 * sets the error message to be used in this exception.
	 * 
	 * @param Message   the error message to be shown to user.
	 */
	public void setMessage(String Message) {
		this.message = Message;
	}

	/**
	 * gets error message of this exception.
	 * 
	 * @return the message of this exception.
	 */
	public String getMessage() {
		return message;
	}
}
