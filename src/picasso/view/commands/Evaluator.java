package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;


import picasso.model.Pixmap;
import picasso.parser.ErrorHandler;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.ButtonPanel;
import picasso.view.Canvas;
import picasso.view.PopUpWindow;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 * @author Bianca Pham
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private  ButtonPanel myUserInterface;
	
	public Evaluator(ButtonPanel userInput) {
		myUserInterface = userInput;
	}
	
	
	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		String test = myUserInterface.getExpression();
//
//		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
//		expr = expTreeGen.makeExpression(test);
		try {
			// create the expression to evaluate just once
			ExpressionTreeNode expr = null;
			
			try {
				expr = createExpression();
				ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
				expr = expTreeGen.makeExpression(test);
				PopUpWindow newWindow = new PopUpWindow(test);
				// call the method on that pixmap
				target = newWindow.getPixmap();
				execute(target, expr);
				newWindow.refresh();
			}
			catch (IOException e) {
				ErrorHandler.getInstance().errorMessage(e, "Error: " +e.getMessage());
				return;
			}
			//ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
			//expr = expTreeGen.makeExpression(test);
			//PopUpWindow newWindow = new PopUpWindow(test);
			// call the method on that pixmap
			//target = newWindow.getPixmap();
			//execute(target, expr);
			//newWindow.refresh();
		}
		catch (ParseException e) {
			ErrorHandler.getInstance().errorMessage(e, "Invalid Expression!");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void execute(Pixmap target, ExpressionTreeNode expr) {
		// create the expression to evaluate just once
//		ExpressionTreeNode expr = createExpression();
		// evaluate it for each pixel
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}

		}
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 * @throws IOException 
	 */
	private ExpressionTreeNode createExpression() throws IOException {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).

		//String test = "floor(y)";
		//String test = "tan(y)";

		//String test = "x + y";
		//String test = "x - y";
		//String test = "x-y";
		//String test = "x -y";
		
		String test = myUserInterface.getExpression();
		

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
	
		return expTreeGen.makeExpression(test);

		// return new Multiply( new X(), new Y() );
	}

}
