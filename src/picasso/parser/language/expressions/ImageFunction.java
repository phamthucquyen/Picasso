package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * Represents the Image function in the Picasso language.
 * @author John Schleider
 */
public abstract class ImageFunction extends ExpressionTreeNode {
	
	String imageName; // This shouldn't be an expression tree node
	ExpressionTreeNode paramX;
	ExpressionTreeNode paramY;
	BufferedImage myimage;
	Dimension mysize;
	

	public ImageFunction(ExpressionTreeNode image, ExpressionTreeNode paramX, ExpressionTreeNode paramY) {
		this.imageName = image.toString();
		this.paramX = paramX;
		this.paramY = paramY;
		
		try {
			File imageFile = new File(new File("images"), this.imageName);
			this.myimage = ImageIO.read(imageFile);
			this.mysize = new Dimension(myimage.getWidth(), myimage.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public RGBColor getCoord(double x, double y) {
		int picture_x = convertcoord(x, mysize.width);
		int picture_y = convertcoord(y, mysize.height);
		int rgbArray = this.myimage.getRGB(picture_x, picture_y);
		Color javaColor = new Color(rgbArray);
		RGBColor convertedColor = new RGBColor(javaColor); 
		return convertedColor;
	}
	
	/**
	 * Takes a coordinate from -1 to 1 and converts it to one scaled for the image
	 * 
	 * @return - the converted coordinate
	 */
	private int convertcoord(double coordval, int maxcoord) {
		// scale the coordinate so that it spans from 0 to 1 instead of -1 to 1
		// we do this by averaging with 1
		double coord = (coordval + 1) / 2;
		// multiply this by the maximum coordinate of the dimension
		coord = coord * maxcoord;
		int intcoord = (int) coord;
		// bound this to the maxcoord or 0
		if (intcoord <= 0) {
			intcoord = 0;
		}
		else if (coord >= maxcoord) {
			intcoord = maxcoord - 1;
		}
		return intcoord;
	}
	
	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".") + 1) + "(" + imageName + ", " + paramX + ", " + paramY + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof ImageFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		ImageFunction uf = (ImageFunction) o;

		// check if their parameters are equal
		if (!this.imageName.equals(uf.imageName) || !this.paramX.equals(uf.paramX) || !this.paramY.equals(uf.paramY)) {
			return false;
		}
		return true;
	}

}
