package picasso.parser;

import java.io.IOException;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Assignment;
import picasso.parser.language.expressions.Variable;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * handles parsing the equals sign
 * @author Bianca Pham
 * @author Ciel Morrill
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) throws ParseException {
		tokens.pop(); 
		ExpressionTreeNode rightNode = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		IdentifierToken v = (IdentifierToken) tokens.pop(); 
		String varName = v.getName();
		Variable var = new Variable(varName);
		return new Assignment(var, rightNode);
		

	}

}
