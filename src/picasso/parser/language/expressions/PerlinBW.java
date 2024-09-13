package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the PerlinBW expression in the Picasso language.
 * @author John Schleider
 */

public class PerlinBW extends PerlinColor {

	public PerlinBW(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor color = super.evaluate(x, y);
		double mean = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
		return new RGBColor(mean, mean, mean);
	}

}
