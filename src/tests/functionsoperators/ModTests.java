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

public class ModTests extends FunctionOperatorTests {

	public ModTests() {
		super();
	}

	@Override
	@Test
	void testParseFunction() {
		Stack<Token> tokens = new Stack<>();
		tokens.push(new IdentifierToken("x"));
		tokens.push(new IdentifierToken("y"));
		tokens.push(new ModToken());

		ExpressionTreeNode actual;
		try {
			actual = semAnalyzer.generateExpressionTree(tokens);
			assertEquals(new Mod(new X(), new Y()), actual);
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
			e = parser.makeExpression("x % y");
			assertEquals(new Mod(new X(), new Y()), e);
		} catch (ParseException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
	}

	@Override
	@Test
	void testTokenize() {
		String expression = "y % x";
		List<Token> tokens;
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("y"), tokens.get(0));
		assertEquals(new ModToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
	}

	@Override
	@Test
	void testEvaluate() {
		Mod myTree = new Mod(new X(), new Y());
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(8, 4));
	}

}
