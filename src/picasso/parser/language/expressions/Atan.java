package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the arc tangent function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Atan extends UnaryFunction {

	/**
	 * Create an arctan expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Atan(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates arc tangent at given x,y point of param function
	 * @return color from evaluating arctan of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
