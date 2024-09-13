package picasso.parser;


import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 * ErrorHandler handles error appropriately for the given exception
 * 
 * @author Alexandra Thorpe
 */
public class ErrorHandler implements ErrorHandlerInterface {
	
	private static ErrorHandler ourInstance;
	
	/**
	 * Make sure that there is only one error handler for the application.
	 * 
	 * @return the error handler
	 */
	public static ErrorHandler getInstance() {
		if (ourInstance == null) {
			ourInstance = new ErrorHandler();
		}
		return ourInstance;
	}

	
	private ErrorHandler() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void errorMessage(Exception e, String message) {
	    JFrame frame = new JFrame("Error Message");
	    
		JOptionPane.showMessageDialog(frame, message, "Error Message", JOptionPane.ERROR_MESSAGE);
		
	}
	
	
	

}
