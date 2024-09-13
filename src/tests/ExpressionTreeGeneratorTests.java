package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.*;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ExpressionTreeGeneratorTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("[1,-1, 1]");
			assertEquals(new RGBColor(1, -1, 1), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("x");
			assertEquals(new X(), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("x + y");
			assertEquals(new Plus(new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}

		// no spaces!
		try {
			e = parser.makeExpression("x+y");
			assertEquals(new Plus(new X(), new Y()), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			e = parser.makeExpression("[1,.3,-1] + y");
			assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			e = parser.makeExpression("x + y + [ -.51, 0, 1]");
			assertEquals(new Plus(new Plus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("x - y");
			assertEquals(new Minus(new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}

		// no spaces!
		try {
			e = parser.makeExpression("x-y");
			assertEquals(new Minus(new X(), new Y()), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			e = parser.makeExpression("[1,.3,-1] - y");
			assertEquals(new Minus(new RGBColor(1, .3, -1), new Y()), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			e = parser.makeExpression("x - y - [ -.51, 0, 1]");
			assertEquals(new Minus(new Minus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e;
		try {
			e = parser.makeExpression("( x + y )");
			assertEquals(new Plus(new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}


		try {
			e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
			assertEquals(new Plus(new X(), new Plus(new Y(), new RGBColor(1, 1, 1))), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			e = parser.makeExpression("(x - (y - [1, 1, 1] ) )");
			assertEquals(new Minus(new X(), new Minus(new Y(), new RGBColor(1, 1, 1))), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			e = parser.makeExpression("(x - (y + [1, 1, 1] ) )");
			assertEquals(new Minus(new X(), new Plus(new Y(), new RGBColor(1, 1, 1))), e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

	@Test
	public void arithmeticStackTests() {
		Stack<Token> stack = parser.infixToPostfix("x + y * x");

		Stack<Token> expected = new Stack<>();
		expected.push(new IdentifierToken("x"));
		expected.push(new IdentifierToken("y"));
		expected.push(new IdentifierToken("x"));
		expected.push(new MultiplyToken());
		expected.push(new PlusToken());

		assertEquals(expected, stack);
	}

	@Test
	public void floorFunctionTests() {
		try {
			ExpressionTreeNode e = parser.makeExpression("floor( x )");
			assertEquals(new Floor(new X()), e);

			e = parser.makeExpression("floor( x + y )");
			assertEquals(new Floor(new Plus(new X(), new Y())), e);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void tanFunctionTests() {
		try {
			ExpressionTreeNode e = parser.makeExpression("tan( x )");
			assertEquals(new Tan(new X()), e);

			e = parser.makeExpression("tan( x + y )");
			assertEquals(new Tan(new Plus(new X(), new Y())), e);
		
			e = parser.makeExpression("tan( x - y )");
			assertEquals(new Tan(new Minus(new X(), new Y())), e);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		

	}

}
