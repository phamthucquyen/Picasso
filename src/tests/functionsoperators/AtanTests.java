package tests.functionsoperators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

import java.io.IOException;
import java.util.List;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;

/**
 * Tests atan function
 * @author Ciel Morrill
 */

class AtanTests extends FunctionOperatorTests {
	
	public AtanTests() {
		super();
	}
	
	@Override
	@Test
	void testParseFunction(){
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new AtanToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new Atan(new X()), actual);
			assertTrue(tokens.empty());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	@Test
	void expressionTest() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("atan(x)");
			assertEquals(new Atan(new X()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	
	@Override
	@Test
	void testTokenize() {
		String expression = "atan(x)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AtanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

	@Override
	@Test
	void testEvaluate() {
		Atan myTree = new Atan(new X());
		RGBColor resultantColor = myTree.evaluate(0.5, 1);
		assertEquals(0.463647609, resultantColor.getRed(), 0.0001);
		assertEquals(0.463647609, resultantColor.getGreen(), 0.0001);
		assertEquals(0.463647609, resultantColor.getBlue(), 0.0001);
		
		myTree = new Atan(new X());
		resultantColor = myTree.evaluate(-0.5, 1);
		assertEquals(-0.463647609, resultantColor.getRed(), 0.0001);
		assertEquals(-0.463647609, resultantColor.getGreen(), 0.0001);
		assertEquals(-0.463647609, resultantColor.getBlue(), 0.0001);
		
		myTree = new Atan(new X());
		resultantColor = myTree.evaluate(0, 1);
		assertEquals(0, resultantColor.getRed(), 0.0001);
		assertEquals(0, resultantColor.getGreen(), 0.0001);
		assertEquals(0, resultantColor.getBlue(), 0.0001);
	}

}
