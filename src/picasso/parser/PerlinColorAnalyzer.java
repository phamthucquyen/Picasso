package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the creation of a random color based on 2D noise.
 * @author John Schleider
 */

public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop();
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new PerlinColor(left, right);
	}

}
