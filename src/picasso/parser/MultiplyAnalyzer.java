package picasso.parser;

import java.util.Stack;

/**
 * Handles parsing the multiplication function
 * 
 * @author John Schleider
 */

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Multiply;
import picasso.parser.tokens.Token;

public class MultiplyAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // Need to remove the floor token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode leftNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode rightNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Multiply(rightNode, leftNode);
	}

}
