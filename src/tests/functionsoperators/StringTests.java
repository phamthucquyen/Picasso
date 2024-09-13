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

public class StringTests extends FunctionOperatorTests {

	public StringTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		
		tokens.push(new StringToken("ColorsNock.png"));
		

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertTrue(new Str("ColorsNock.png").equals(actual));
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
			e = parser.makeExpression("\"ColorsNock.png\"");
			assertTrue(new Str("ColorsNock.png").equals(e));
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}
	
	@Test
	void testParseFunctionAdvanced() {
		Stack<Token> tokens = new Stack<>();
		
		tokens.push(new StringToken("ColorsNock.png"));
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new ImageWrapToken());
		
		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new ImageWrap(new Str("ColorsNock.png"), new X(), new Y()),actual);
			assertTrue(tokens.empty());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "\"ColorsNock.png\"";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		//assertEquals(new QuoteToken(), tokens.get(0));
		assertEquals(new StringToken("ColorsNock.png"), tokens.get(0));
		//assertEquals(new QuoteToken(), tokens.get(2));
	}

	@Override
	@Test
	void testEvaluate() {
		Str mytree;
		//try {
			mytree = new Str("ColorsNock.png");
			RGBColor pixel = mytree.evaluate(-0.5, -0.5);
			assertEquals(1, pixel.getRed());
			assertEquals(-1, pixel.getGreen());
			assertEquals(1, pixel.getBlue());
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

}
