package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Minus;

/**
 * Handles parsing the minus or "subtraction function".
 * 
 * @author Alexandra Thorpe
 */
public class MinusAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); // Remove the minus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		
		
		ExpressionTreeNode leftNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		ExpressionTreeNode rightNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		
		return new Minus(rightNode, leftNode);	
		
	}	

}
