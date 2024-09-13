package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the mod function in the Picasso language.
 * @author John Schleider
 */

public class Mod extends BinaryOperator {

	public Mod(ExpressionTreeNode leftNode, ExpressionTreeNode rightNode) {
		super(leftNode, rightNode);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = leftNode.evaluate(x, y);
		RGBColor result2 = rightNode.evaluate(x, y);
		double red = result1.getRed() % result2.getRed();
		double green = result1.getGreen() % result2.getGreen();
		double blue = result1.getBlue() % result2.getBlue();

		return new RGBColor(red, green, blue);
	}

}
