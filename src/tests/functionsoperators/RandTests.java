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
 * Tests random()
 * @author Ciel Morrill
 */

public class RandTests extends FunctionOperatorTests {

	public RandTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		tokens.push(new RandomToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertNotEquals(new Rand(), actual);
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
			e = parser.makeExpression("random()");
			assertNotEquals(new Rand(), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "random()";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RandomToken(), tokens.get(0));
	}

	@Override
	@Test
	void testEvaluate() {
		Rand myTree = new Rand();
		RGBColor resultantColor = myTree.evaluate(0, 0);
		RGBColor max = new RGBColor(1.0, 1.0, 1.0);
		RGBColor min = new RGBColor(-1.0, -1.0, -1.0);
		assertTrue(resultantColor.getRed() <= max.getRed() && resultantColor.getRed() >= min.getRed());
		assertTrue(resultantColor.getGreen() <= max.getGreen() && resultantColor.getGreen() >= min.getGreen());
		assertTrue(resultantColor.getBlue() <= max.getBlue() && resultantColor.getBlue() >= min.getBlue());
	}

}
