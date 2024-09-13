/**
 * 
 */
package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cos;
import picasso.parser.tokens.Token;

/**
 *  * Handles parsing the cosine function.
 *  @author Bianca Pham
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	/**
	 * @param tokens
	 * @return
	 * @throws IOException 
	 * @see picasso.parser.UnaryFunctionAnalyzer#generateExpressionTree(java.util.Stack)
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token(s) on the stack.
		// But, it needs to be processed
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Cos(paramETN);
	}

}
