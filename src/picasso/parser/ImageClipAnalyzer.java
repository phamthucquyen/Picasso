package picasso.parser;

import java.io.IOException;


/**
 * Handles parsing the imageclip function

 * @author John Schleider
 */

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.Token;

public class ImageClipAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop();
		ExpressionTreeNode param1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode imageAddress = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new ImageClip(imageAddress, param2, param1);
	}

}
