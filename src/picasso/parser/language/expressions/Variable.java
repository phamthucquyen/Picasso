package picasso.parser.language.expressions;

import java.util.Objects;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 * @author Bianca Pham
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return null;
	}
	
	public String getName() {
		return name;
	}

//	/**
//	 * @return
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
//	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		return Objects.equals(name, other.name);
	}
	
	

}
