package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the RBG to luminance/chrominance function in Picasso.
 * @author John Schleider
 */

public class RGBToYCrCb extends UnaryFunction {

	public RGBToYCrCb(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor rgbColor = param.evaluate(x, y);
		double red = rgbColor.getRed();
		double green = rgbColor.getGreen();
		double blue = rgbColor.getBlue();
		double Y = 0.299 * red + 0.587 * green + 0.144 * blue;
		double Cr = -0.14713 * red + -0.28886 * green + 0.436 * blue;
		double Cb = 0.615 * red + -0.51499 * green + -0.10001 * blue;
		return new RGBColor(Y, Cr, Cb);
	}

}
