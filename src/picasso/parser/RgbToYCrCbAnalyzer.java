package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.RGBToYCrCb;

/**
 * Handles parsing the conversion from RBG to luminance/chrominance space.
 * @author John Schleider
 */

public class RgbToYCrCbAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		Token t = tokens.pop();
		ExpressionTreeNode rgbColor = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new RGBToYCrCb(rgbColor);
	}

}
