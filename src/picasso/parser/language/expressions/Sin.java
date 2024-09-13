package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the sine function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Sin extends UnaryFunction {

	/**
	 * Create a sine expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Sin(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates sine at given x,y point of param function
	 * @return color from evaluating sine of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.sin(result.getRed());
		double green = Math.sin(result.getGreen());
		double blue = Math.sin(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
