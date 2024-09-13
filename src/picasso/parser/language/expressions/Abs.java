package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the absolute value function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Abs extends UnaryFunction {

	/**
	 * Creates an absolute value expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Abs(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates absolute value at given x,y point of param function
	 * @return color from evaluating absolute value of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
