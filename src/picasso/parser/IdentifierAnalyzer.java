package picasso.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
//import picasso.parser.language.expressions.Equals;
//import picasso.parser.language.expressions.Variable;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
//import picasso.parser.tokens.chars.EqualsToken;
//import picasso.parser.tokens.chars.EqualsToken;


/**
 * Handle an identifier token 
 * 
 * @author Sara Sprenkle
 * @author Bianca Pham
 */
public class IdentifierAnalyzer implements SemanticAnalyzerInterface {

	static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();

	static {
		// We always have x and y defined.
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {

		IdentifierToken t = (IdentifierToken) tokens.pop();
		String id = t.getName();
		// i want it to map expression tree to id
		
		//idToExpression.putIfAbsent(id, Equals(id));
		ExpressionTreeNode mapped = idToExpression.get(id);
		if (mapped != null) {
			return mapped;
		}

		// TODO : What should we do if we don't recognize the identifier?
		// Is that an error? Or, could there a valid reason?
		return null;
	}

	public static void fromExpressionToAssignment(String variable, ExpressionTreeNode expression) {
		// TODO Auto-generated method stub
		//System.out.println(idToExpression);
		
		//if the map does not have the variable, add it 
		if (!idToExpression.containsKey(variable)) {
			idToExpression.put(variable, expression);
		}
		//otherwise replace the variable's expression with the new expression
		else {
			idToExpression.replace(variable, expression);
		}

	}
	
	
	public static Map<String, ExpressionTreeNode> getMapping() {
		return idToExpression;
	}
	
	/*
	 * 		
	   if(tokens.pop() instanceof EqualsToken) {
			System.out.println("its an instance lamo");
			while(!(tokens.pop() instanceof IdentifierToken)) {
				for(Token t: tokens) {
					System.out.println("The token is, " + t);
				}
			}
		}
	 */

}
