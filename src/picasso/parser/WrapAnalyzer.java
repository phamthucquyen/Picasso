package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Wrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the wrap around [-1, 1] function.
 * 
 * @author Ciel Morrill
 * 
 */

public class WrapAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop();
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Wrap(paramETN);
	}
}
