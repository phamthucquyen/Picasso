package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Divide;
import picasso.parser.language.expressions.Mod;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the divide operator
 * 
 * @author John Schleider
 */
public class DivideAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); 
		ExpressionTreeNode denominator = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode numerator = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new Divide(numerator, denominator);
	}

}
