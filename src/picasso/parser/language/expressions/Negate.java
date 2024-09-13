package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents negation in Picasso
 * @author Ciel Morrill
 */

public class Negate extends UnaryFunction {

	/**
	 * Create a negation expression that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Negate(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates negation of given x,y point of param function
	 * @return color from evaluating negation of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = -1 * result.getRed();
		double green = -1 * result.getGreen();
		double blue = -1 * result.getBlue();

		return new RGBColor(red, green, blue);
	}

}