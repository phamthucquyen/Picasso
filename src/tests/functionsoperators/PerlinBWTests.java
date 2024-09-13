package tests.functionsoperators;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

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

public class PerlinBWTests extends FunctionOperatorTests {

	public PerlinBWTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new PerlinBWToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertTrue(new PerlinBW(new X(), new Y()).equals(actual));
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
			e = parser.makeExpression("perlinBW(x, y)");
			assertEquals(new PerlinBW(new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "perlinBW(x, y)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new PerlinBWToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
	}

	@Override
	@Test
	void testEvaluate() {
		// Right now this is specific to my device. I will change this.
		PerlinBW perlinFunc = new PerlinBW(new X(), new Y());
		RGBColor returnColor = perlinFunc.evaluate(-0.8, -0.8725);
		assertEquals(-0.2325032666, returnColor.getRed(), 0.0001);
		assertEquals(-0.2325032666, returnColor.getGreen(), 0.0001);
		assertEquals(-0.2325032666, returnColor.getBlue(), 0.0001);
	}

}
