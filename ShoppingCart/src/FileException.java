

public class FileException extends PersistenceException {

	private String message;


	public void setMessage(String Message) {
		this.message = Message;
	}


	public String getMessage() {
		return message;
	}
}