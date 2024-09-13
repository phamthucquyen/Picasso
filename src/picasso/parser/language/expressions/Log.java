package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the sine function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Log extends UnaryFunction {

	/**
	 * Create a log expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Log(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates log at given x,y point of param function
	 * @return color from evaluating sine of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(Math.abs(result.getRed()));
		double green = Math.log(Math.abs(result.getGreen()));
		double blue = Math.log(Math.abs(result.getBlue()));

		return new RGBColor(red, green, blue);
	}
}
