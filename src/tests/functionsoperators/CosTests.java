package tests.functionsoperators;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;

public class CosTests extends FunctionOperatorTests {

	public CosTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new CosToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new Cos(new X()), actual);
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
			e = parser.makeExpression("cos(x)");
			assertEquals(new Cos(new X()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "cos(x)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new CosToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

	@Override
	@Test
	void testEvaluate() {
		Cos myTree = new Cos(new X());
		RGBColor resultantColor = myTree.evaluate(0.555, 1);
		assertEquals(0.8499004403, resultantColor.getRed(), 0.0001);
		assertEquals(0.8499004403, resultantColor.getGreen(), 0.0001);
		assertEquals(0.8499004403, resultantColor.getBlue(), 0.0001);
		
		myTree = new Cos(new X());
		resultantColor = myTree.evaluate(-0.555, 1);
		assertEquals(0.8499004403, resultantColor.getRed(), 0.0001);
		assertEquals(0.8499004403, resultantColor.getGreen(), 0.0001);
		assertEquals(0.8499004403, resultantColor.getBlue(), 0.0001);
		
		myTree = new Cos(new X());
		resultantColor = myTree.evaluate(0, 1);
		assertEquals(1, resultantColor.getRed(), 0.0001);
		assertEquals(1, resultantColor.getGreen(), 0.0001);
		assertEquals(1, resultantColor.getBlue(), 0.0001);
	}

}
