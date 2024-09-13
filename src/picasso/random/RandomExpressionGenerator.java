package picasso.random;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 * Creates a random expression using strings
 * @author John Schleider
 */
public class RandomExpressionGenerator {

	// Operators have a left and a right side
	List<String> operators = new ArrayList<>();
	List<String> functions = new ArrayList<>();
	List<String> idTokens = new ArrayList<>();
	Random r = new Random(); // Random number generator
	int nothingWeight = 3; // MUST be greater than or equal to 1
	int binaryNothingWeight = 6; // MUST be greater than or equal to 1
	
	public RandomExpressionGenerator() {
		setupOperators();
		setupFunctions();
		idTokens.add("x");
		idTokens.add("y");
	}
	
	private void setupOperators() {
		// we do NOT include the negate operator here -- it acts like a function
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		operators.add("%");
		operators.add("^");
	}
	
	/**
	 * Gets the functions from the functions.conf file
	 */
	private void setupFunctions() {
		// we add the negate operator here -- it acts like a function
		functions.add("!");
		
		// reads the functions.conf file for every new line
		File functionsConf = new File(new File("conf"), "functions.conf");
		try {
			FileReader out = new FileReader(functionsConf);
			BufferedReader func = new BufferedReader(out);
			String line = "";
			while ((line = func.readLine()) != null) {
				functions.add(line);
			}
			func.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Recursively forms a random expression
	 * 
	 * @param nextType - the next type of the part of the expression (operator, ID, function, or none)
	 */
	public String expressionBuilder() {
		String returnStr = "";
		int nextType = r.nextInt(2);
		
		// we return some ID token or number and call the thing again, requiring a binary operator
		// we do not need more stuff in this part of the equation
		if (nextType == 0) {
			returnStr = returnStr + getId() + getBinary();
		}
		// we return a function
		else if (nextType == 1) {
			returnStr = returnStr + getFunction() + getBinary();
		}
		else {
			returnStr = "";
		}
		return returnStr;
	}
	
	/**
	 * MUST return a random ID token or color
	 */
	private String getId() {
		int options = idTokens.size() + 1; // add 1 for the random color option
		int choice = r.nextInt(options);
		// return an ID token
		if (choice < idTokens.size()) {
			return idTokens.get(choice);
		}
		// return a random color
		else {
			String colorStr = "[";
			colorStr = colorStr + r.nextDouble(-1,1);
			colorStr = colorStr + ", ";
			colorStr = colorStr + r.nextDouble(-1,1);
			colorStr = colorStr + ", ";
			colorStr = colorStr + r.nextDouble(-1,1);
			colorStr = colorStr + "]";
			return colorStr;
		}
	}
	
	/**
	 * returns a binary operator or nothing (based on binaryNothingWeight)
	 * 
	 * @return
	 */
	private String getBinary() {
		int options = operators.size() + binaryNothingWeight;
		int choice = r.nextInt(options);
		if (choice < operators.size()) {
			return operators.get(choice) + expressionBuilder();
		}
		else {
			return "";
		}
	}
	
	/**
	 * MSUT return a function
	 * 
	 * @return
	 */
	private String getFunction() {
		int options = functions.size();
		int choice = r.nextInt(options);
		String function = functions.get(choice);
		// now that we have our function, we need to figure out what it needs inside
		// can be 0, 1, 2, or 3 things
		if (function.equals("random")) {
			function = function + "()";
		}
		else if ((function.equals("imageWrap")) || (function.equals("imageClip"))) {
			// TODO: Figure out how to handle images!
			function = "random()";
		}
		else if ((function.equals("perlinBW")) || (function.equals("perlinColor"))) {
			function = function + "(" + expressionBuilder() + "," + expressionBuilder() + ")";
		}
		else if (function.equals("!")) {
			function = function + "(" + expressionBuilder() + ")";
		}
		// Unary function
		else {
			function = function + "(" + expressionBuilder() + ")";
		}
		return function;
	}
	
	public static void main(String[] args) {
		RandomExpressionGenerator randGen = new RandomExpressionGenerator();
		String soRandom = randGen.expressionBuilder();
		System.out.println(soRandom);
	}

}
