package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Abstract class for a binary operator
 * 
 * @author John Schleider
 */ 
public abstract class BinaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode leftNode; 
	ExpressionTreeNode rightNode;
	
	public BinaryOperator(ExpressionTreeNode leftNode, ExpressionTreeNode rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
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
		return classname.substring(classname.lastIndexOf(".") + 1) + "(" + leftNode + "+" + rightNode + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator bo = (BinaryOperator) o;

		// check if their parameters are equal
		if ((!this.leftNode.equals(bo.leftNode)) && (!this.rightNode.equals(bo.rightNode))) {
			return false;
		}
		return true;
	}

}
