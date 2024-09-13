package picasso.parser;

/**
 * Error Handler Interface
 * 
 * @author Alexandra Thorpe
 */
public interface ErrorHandlerInterface {
	
	/**
	 * 
	 * @param exception type
	 * @param message to display
	 */
	public void errorMessage(Exception e, String message);

}
