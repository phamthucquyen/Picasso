package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the image wrap function in the Picasso language.
 * @author John Schleider
 */
public class ImageWrap extends ImageFunction {

	public ImageWrap(ExpressionTreeNode image, ExpressionTreeNode paramX, ExpressionTreeNode paramY) {
		super(image, paramX, paramY);
	}

	/**
	 * We need to make it such that the image wraps around as needed...
	 * 
	 * Somehow we need to reference the pixels in an image
	 * 
	 * ImageWrap("imagepath.jpg", f(x), f(y) )
	 * The f(x) will take an x coordinate and return the x coordinate referenced in the image
	 * Likewise for f(y)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor eval_x = paramX.evaluate(x, y);
		RGBColor eval_y = paramY.evaluate(x, y);
		double mean_x = eval_x.getRed() + eval_x.getGreen() + eval_x.getBlue();
		double mean_y = eval_y.getRed() + eval_y.getGreen() + eval_y.getBlue();
		mean_x = mean_x / 3;
		mean_y = mean_y / 3;
		double wrap_x = wrapcoord(mean_x); 
		double wrap_y = wrapcoord(mean_y);
		RGBColor newcolor = super.getCoord(wrap_x, wrap_y);
		return newcolor;
	}
	
	private static double wrapcoord(double i) {
		if (i > 1) {
			return ((i - 1) % 2) - 1;
		} else if (i < -1) {
			return (1 - ((0 - 1 - i) % 2));
		}
		return i;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageWrap other = (ImageWrap) obj;
		if ((paramX.equals(other.paramX)) && (paramY.equals(other.paramY)) && (imageName.equals(other.imageName)))
			return true;
		return false;
	}

}
