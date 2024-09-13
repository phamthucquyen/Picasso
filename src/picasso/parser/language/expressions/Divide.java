package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the divide function in the Picasso language.
 * 
 * @author John Schleider
 */
public class Divide extends BinaryOperator {

	public Divide(ExpressionTreeNode numerator, ExpressionTreeNode denominator) {
		super(numerator, denominator);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor num = leftNode.evaluate(x, y);
		RGBColor den = rightNode.evaluate(x, y);
		double red = num.getRed() / den.getRed();
		double green = num.getGreen() / den.getGreen();
		double blue = num.getBlue() / den.getBlue();

		return new RGBColor(red, green, blue);
	}

}
