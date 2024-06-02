package DATABASE;

public class ExceptionRegester extends Exception{
	private String message ;

	public ExceptionRegester(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
