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
 * Tests Assignment operation
 * @author Ciel Morrill
 */

public class AssignmentTests extends FunctionOperatorTests {

	public AssignmentTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		// a =  x + y
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("a"));
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new PlusToken());
		tokens.push(new EqualsToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			ExpressionTreeNode exp = new Plus(new X(), new Y());
			assertEquals(new Assignment(new Variable("a"), exp), actual);
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
			e = parser.makeExpression("a = x + y");
			ExpressionTreeNode exp = new Plus(new X(), new Y());
			assertEquals(new Assignment(new Variable("a"), exp), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "a = x + y";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("a"), tokens.get(0));
		assertEquals(new EqualsToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new PlusToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
	}

	@Override
	@Test
	void testEvaluate() {
		Assignment myTree = new Assignment(new Variable("a"), new Plus(new X(), new Y()));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(0.25, 0.25));
	}

}
