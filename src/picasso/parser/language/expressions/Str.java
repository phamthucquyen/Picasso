package picasso.parser.language.expressions;

import java.util.Objects;

import javax.imageio.ImageIO;

import picasso.parser.ErrorHandler;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * Represents a string entered into Picasso
 * 
 * @author John Schleider
 */
public class Str extends ExpressionTreeNode {

	private String str;
	private BufferedImage myimage;
	private Dimension mysize;
	
	
	public Str(String str) throws ParseException {
		this.str = str;
		
		try {
			File imageFile = new File(new File("images"), this.str);
			this.myimage = ImageIO.read(imageFile);
			this.mysize = new Dimension(myimage.getWidth(), myimage.getHeight());
		} catch (IOException e) {
			throw new ParseException("Failed to read file " + this.str + " ");
		}
		
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int picture_x = (int) (mysize.width * ((x + 1) / 2)) % mysize.width;
		int picture_y = (int) (mysize.height * ((y + 1) / 2)) % mysize.height;
		int rgbArray = this.myimage.getRGB(picture_x, picture_y);
		Color javaColor = new Color(rgbArray);
		RGBColor convertedColor = new RGBColor(javaColor); 
		return convertedColor;
	}
	
	public String toString() {
		return this.str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(str);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Str other = (Str) obj;
		return Objects.equals(str, other.str);
	}
	
	

}
