package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Rand;
import picasso.parser.tokens.Token;

/**
 * Handles parsing random color generation.
 * @author John Schleider
 */

public class RandomAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		Token t = tokens.pop();
		return new Rand();
	}

}
