package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Ciel Morrill
 * 
 */

public class Wrap extends UnaryFunction {

	/**
	 * Create a wrap expression around [-1, 1] that takes ETN as a param
	 * @param param ExpressionTreeNode expression
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates wrap around [-1, 1] at given x,y point of param function
	 * @return color from evaluating wrap around [-1, 1] of param expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double r = result.getRed();
		double g = result.getGreen();
		double b = result.getBlue();

		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		// for some reason, x % 1 iff x < -1 outputs something different in java
		// versus my calculator. so i had to get creative with the equations
		if (r > 1.0) {
			red = -1.0 * (1.0 - (r % 1.0));
		}
		else if (r < (-1.0)){
			r *= -1.0;
			red = -1.0 * (1.0 - (r % 1.0));
			red *= -1.0;
		}
		if (g > 1.0) {
			green = -1.0 * (1.0 - (g % 1.0));
		}
		else if (g < (-1.0)){
			g *= -1.0;
			green = -1.0 * (1.0 - (g % 1.0));
			green *= -1.0;
		}
		if (b > 1.0) {
			blue = -1.0 * (1.0 - (b % 1.0));
		}
		else if (b < (-1.0)){
			b *= -1.0;
			blue = -1.0 * (1.0 - (b % 1.0));
			blue *= -1.0;
		}
		
		return new RGBColor(red, green, blue);
	}

}
