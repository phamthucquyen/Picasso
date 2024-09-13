package picasso.parser;

import java.io.IOException;
import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.StringToken;
import picasso.parser.language.expressions.Str;

/**
 * Handles parsing strings, as in reading photo URLs.
 * @author John Schleider
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException{
		//Token topToken = tokens.pop();
		StringToken strToken = (StringToken) tokens.pop();
		String str = strToken.getString();
		return new Str(str);
	}

}
