package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Carries out exponent function
 * @author Ciel Morrill
 */

public class Exponent extends BinaryOperator {

	public Exponent(ExpressionTreeNode leftNode, ExpressionTreeNode rightNode) {
		super(leftNode, rightNode);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = leftNode.evaluate(x, y);
		RGBColor result2 = rightNode.evaluate(x, y);
		double red = Math.pow(result1.getRed(), result2.getRed());
		double green = Math.pow(result1.getGreen(),result2.getGreen());
		double blue = Math.pow(result1.getBlue(), result2.getBlue());

		return new RGBColor(red, green, blue);
	}

}
