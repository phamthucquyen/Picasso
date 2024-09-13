package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageClip function in the Picasso language.
 * @author John Schleider
 */
public class ImageClip extends ImageFunction {

	public ImageClip(ExpressionTreeNode image, ExpressionTreeNode paramX, ExpressionTreeNode paramY) {
		super(image, paramX, paramY);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor eval_x = paramX.evaluate(x, y);
		RGBColor eval_y = paramY.evaluate(x, y);
		double mean_x = eval_x.getRed() + eval_x.getGreen() + eval_x.getBlue();
		double mean_y = eval_y.getRed() + eval_y.getGreen() + eval_y.getBlue();
		mean_x = mean_x / 3;
		mean_y = mean_y / 3;
		double wrap_x = clipcoord(mean_x); 
		double wrap_y = clipcoord(mean_y);
		RGBColor newcolor = super.getCoord(wrap_x, wrap_y);
		return newcolor;
	}

	private static double clipcoord(double i) {
		if (i > 1.0) {
			return 1.0;
		} else if (i < -1.0) {
			return -1.0;
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
		ImageClip other = (ImageClip) obj;
		if ((paramX.equals(other.paramX)) && (paramY.equals(other.paramY)) && (imageName.equals(other.imageName)))
			return true;
		return false;
	}
	
}
