/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of expression trees
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testTanEvaluation() {
		Tan myTree = new Tan(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate((Math.PI/4), 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate((Math.PI/-4), 0));
		
		
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			double answer = Math.tan(i);
			assertEquals(new RGBColor(answer, answer, answer), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(answer, answer, answer), myTree.evaluate(i, i));
		}
		
		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double tanOfTestVal = Math.tan(testVal);
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
		

		
		//more tests?
		
		

	
	}
	
	@Test
	public void testMinusEvaluation() {
		Minus myTree = new Minus(new X(), new Y());
		
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(-1,-1));
		assertEquals(new RGBColor(1,1,1), myTree.evaluate(1,-1));
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(0,0));
		assertEquals(new RGBColor(-1,-1,-1), myTree.evaluate(-1,1));
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(1,1));
		
		
	}

	// TODO: More tests of evaluation

}
