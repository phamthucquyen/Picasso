package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the luminance/chrominance to RBG function in Picasso.
 * @author John Schleider
 */

public class YCrCbToRGB extends UnaryFunction {

	public YCrCbToRGB(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor rgbColor = param.evaluate(x, y);
		double Y = rgbColor.getRed();
		double Cr = rgbColor.getGreen();
		double Cb = rgbColor.getBlue();
		double red = 1 * Y + 0 * Cr + 1.13983 * Cb;
		double green = 1 * Y + -0.39465 * Cr + -0.5806 * Cb;
		double blue = 1 * Y + 2.03211 * Cr + 0 * Cb;
		return new RGBColor(red, green, blue);
	}

}
