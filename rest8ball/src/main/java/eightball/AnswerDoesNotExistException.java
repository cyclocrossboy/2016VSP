package eightball;

public class AnswerDoesNotExistException extends Exception {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5581028912225805089L;
	private static final String MESSAGE_FORMAT = "Enter a question other then the default question: '%s'";
	 
	 public AnswerDoesNotExistException(String query){
		 super(String.format(MESSAGE_FORMAT, query));
	 }

}
