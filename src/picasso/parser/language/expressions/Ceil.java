package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ceiling function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Ceil extends UnaryFunction {

	/**
	 * Create a ceiing expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Ceil(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates ceiling at given x,y point of param function
	 * @return color from evaluating ceiling of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.ceil(result.getRed());
		double green = Math.ceil(result.getGreen());
		double blue = Math.ceil(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
