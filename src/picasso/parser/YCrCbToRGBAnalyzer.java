package picasso.parser;

import java.io.IOException;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.YCrCbToRGB;
import picasso.parser.tokens.Token;

/**
 * Handles parsing converting color from luminance/chrominance space to RBG
 * @author John Schleider
 */

public class YCrCbToRGBAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		Token t = tokens.pop();
		ExpressionTreeNode rgbColor = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new YCrCbToRGB(rgbColor);
	}

}
