package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponent;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the * or "exponent function".
 * 
 * @author Ciel Morrill
 */
public class ExponentAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // pops off the *
		ExpressionTreeNode leftNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode rightNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Exponent(rightNode, leftNode);

	}

}
