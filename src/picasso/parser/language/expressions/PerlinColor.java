package picasso.parser.language.expressions;

import java.util.Objects;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the PerlinColor expression in the Picasso language.
 * @author John Schleider
 */

public class PerlinColor extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;
	
	public PerlinColor(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		double red = ImprovedNoise.noise(l.getRed() + 0.3, r.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(l.getBlue() + 0.1, r.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(l.getGreen() - 0.8, r.getGreen() - 0.8, 0);
		return new RGBColor(red, blue, green);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerlinColor other = (PerlinColor) obj;
		return this.left.equals(other.left) && this.right.equals(other.right);
	}
	
	

}
