package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the bang sign/exclamation mark, or "negate function".
 * 
 * @author Ciel Morrill
 */

public class NegateAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // this should be the exclamation mark
		ExpressionTreeNode exp = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Negate(exp);

	}

}
