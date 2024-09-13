package tests.functionsoperators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBToYCrCb;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.LeftParenToken;
import picasso.parser.tokens.chars.RightParenToken;
import picasso.parser.tokens.functions.RgbToYCrCbToken;

public class RgbToYCrCbTests extends FunctionOperatorTests {

	public RgbToYCrCbTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new RgbToYCrCbToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new RGBToYCrCb(new X()), actual);
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
			e = parser.makeExpression("rgbToYCrCb(x)");
			assertEquals(new RGBToYCrCb(new X()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "rgbToYCrCb(x)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RgbToYCrCbToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

	@Override
	@Test
	void testEvaluate() {
		RGBToYCrCb myTree = new RGBToYCrCb(new X());
		RGBColor resultantColor = myTree.evaluate(0.555, 1);
		assertEquals(0.57165, resultantColor.getRed(), 0.0001);
		assertEquals(0.000005, resultantColor.getGreen(), 0.0001);
		assertEquals(0, resultantColor.getBlue(), 0.0001);
	}

}
