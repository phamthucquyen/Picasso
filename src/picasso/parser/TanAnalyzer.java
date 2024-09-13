package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the tan function.
 * 
 * @author Alexandra Thorpe
 * 
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // Need to remove the tan token
		// the parameter is the next token(s) on the stack.
		// But, it needs to be processed
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Tan(paramETN);
	}

}
