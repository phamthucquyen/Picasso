package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Log;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the log function.
 * 
 * @author Ciel Morrill
 * 
 */

public class LogAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop();
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Log(paramETN);
	}
}
