package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the clamp function in the Picasso language.
 * 
 * @author Ashton Dill
 * 
 */
public class Clamp extends UnaryFunction {

	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by 'clamping' values above 1 to 1, and
	 * values below -1 to -1.
	 * 
	 * @return the color from 'clamping' values above 1 to 1, and values below -1 to -1.
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
        double clampedRed = Math.max(-1, Math.min(result.getRed(), 1));
        double clampedGreen = Math.max(-1, Math.min(result.getGreen(), 1));
        double clampedBlue = Math.max(-1, Math.min(result.getBlue(), 1));

        return new RGBColor(clampedRed, clampedGreen, clampedBlue);
	}
}
