package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import java.util.Random;

/**
 * Represents the rand (random) expression in the Picasso language.
 * @author John Schleider
 */
public class Rand extends ExpressionTreeNode {

	Random r = new Random();
	private double red;
	private double green;
	private double blue;
	
	
	public Rand() {
		this.red = this.r.nextDouble() * 2 - 1;
		this.green = this.r.nextDouble() * 2 - 1;
		this.blue = this.r.nextDouble() * 2 - 1;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(this.red, this.green, this.blue);
	}

}
