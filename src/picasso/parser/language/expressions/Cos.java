/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the cos function in the Picasso language.
 * 
 * @author Bianca Pham 
 */
public class Cos extends UnaryFunction {

	/**
	 * @param param
	 */
	public Cos(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.cos(result.getRed());
		double green = Math.cos(result.getGreen());
		double blue = Math.cos(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
