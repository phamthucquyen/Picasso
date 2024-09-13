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

public class ImageClipTests extends FunctionOperatorTests {

	public ImageClipTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		
		tokens.push(new StringToken("ColorsNock.png"));
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new ImageClipToken());

		try {
			ExpressionTreeNode actual;
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertTrue(tokens.empty());
		} 
		catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}

	}

	@Override
	@Test
	void expressionTest() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("imageClip(\"ColorsNock.png\", x, y)");
			assertEquals(new ImageClip(new Str("ColorsNock.png"), new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "imageClip(\"ColorsNock.png\", x, y)";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ImageClipToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new StringToken("ColorsNock.png"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new CommaToken(), tokens.get(5));
		assertEquals(new IdentifierToken("y"), tokens.get(6));
		assertEquals(new RightParenToken(), tokens.get(7));
	}

	@Override
	@Test
	void testEvaluate() {
		// Right now this is specific to my device. I will change this.
		ImageClip iwFunc;
		//try {
			iwFunc = new ImageClip(new Str("ColorsNock.png"),new Plus( new X(), new X()), new Y());
			RGBColor returnColor = iwFunc.evaluate(-0.8, -0.8725);
			assertEquals(-1, returnColor.getRed(), 0.0001);
			assertEquals(0.090196, returnColor.getGreen(), 0.0001);
			assertEquals(-0.513725, returnColor.getBlue(), 0.0001);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

}
