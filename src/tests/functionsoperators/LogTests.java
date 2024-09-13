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
 * Tests log function
 * @author Ciel Morrill
 */

class LogTests extends FunctionOperatorTests {
	
	public LogTests() {
		super();
	}
	
	@Override
	@Test
	void testParseFunction(){
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new LogToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new Log(new X()), actual);
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
			e = parser.makeExpression("log(x)");
			assertEquals(new Log(new X()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	
	@Override
	@Test
	void testTokenize() {
		String expression = "log(x)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new LogToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

	@Override
	@Test
	void testEvaluate() {
		Log myTree = new Log(new X());
		RGBColor resultantColor = myTree.evaluate(0.5, 1);
		assertEquals(-0.6931471805599453, resultantColor.getRed(), 0.0001);
		assertEquals(-0.6931471805599453, resultantColor.getGreen(), 0.0001);
		assertEquals(-0.6931471805599453, resultantColor.getBlue(), 0.0001);
		
		myTree = new Log(new X());
		resultantColor = myTree.evaluate(-0.5, 1);
		assertEquals(-0.6931471805599453, resultantColor.getRed(), 0.0001);
		assertEquals(-0.6931471805599453, resultantColor.getGreen(), 0.0001);
		assertEquals(-0.6931471805599453, resultantColor.getBlue(), 0.0001);
		
		myTree = new Log(new X());
		resultantColor = myTree.evaluate(1, 1);
		assertEquals(0, resultantColor.getRed(), 0.0001);
		assertEquals(0, resultantColor.getGreen(), 0.0001);
		assertEquals(0, resultantColor.getBlue(), 0.0001);
	}

}
