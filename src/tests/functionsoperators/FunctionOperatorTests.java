package tests.functionsoperators;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;


public abstract class FunctionOperatorTests {
	
	protected Tokenizer tokenizer;
	protected List<Token> tokens;
	protected SemanticAnalyzer semAnalyzer;
	protected ExpressionTreeGenerator parser;
	
	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
		semAnalyzer = SemanticAnalyzer.getInstance();
		parser = new ExpressionTreeGenerator();
	}
	
	@Test
	abstract void testParseFunction();
	
	@Test
	abstract void expressionTest();
	
	@Test
	abstract void testTokenize();
	
	@Test
	abstract void testEvaluate();


}
