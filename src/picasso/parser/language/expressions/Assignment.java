package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Link left hand side and right hand side of the assignment
 * 
 * @author Sara Sprenkle
 * @author Bianca Pham
 *
 */
public class Assignment extends ExpressionTreeNode {
	private Variable variable;
	private ExpressionTreeNode expression;

	public Assignment(Variable variable, ExpressionTreeNode expression) {
		this.variable = variable;
		this.expression = expression;
		IdentifierAnalyzer.fromExpressionToAssignment(variable.getName(), expression);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Assignment)) {
			return false;
		}

		Assignment other = (Assignment) o;

		if (!(this.variable.equals(other.variable))) {
			return false;
		}
		if (!(this.expression.equals(other.expression))) {
			return false;
		}
		return true;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return expression.evaluate(x, y);
	}

//    public String toString() {
//        StringBuilder rep = new StringBuilder("Left side of assignment: ");
//        rep.append(variable);
//        rep.append("\nright hand side: ");
//        rep.append(expression);
//        return rep.toString();
//    }

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append(variable);
		str.append(" = ");
		str.append(expression);
		return str.toString();
	}
}
