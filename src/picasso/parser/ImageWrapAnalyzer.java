package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the imagewrap function
 * @author John Schleider
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop();
		ExpressionTreeNode param1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode imageAddress = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new ImageWrap(imageAddress, param2, param1);
	}

}
