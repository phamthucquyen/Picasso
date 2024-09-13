package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Mod;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the mod or "mod function".
 * 
 * @author John Schleider
 */
public class ModAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // Need to remove the floor token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode leftNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode rightNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Mod(rightNode, leftNode);
	}

}
